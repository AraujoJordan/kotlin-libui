package libui

import kotlinx.cinterop.*
import platform.posix.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Form]
// - [Grid]
// - [HorizontalBox]
// - [VerticalBox]
// - [Tab]
// - [Group]
//
// Data entry widgets:
// - [Entry]
// - [PasswordEntry]
// - [SearchEntry]
// - [MultilineEntry]
// - [NonWrappingMultilineEntry]
// - [Checkbox]
// - [Combobox]
// - [EditableCombobox]
// - [Spinbox]
// - [Slider]
// - [RadioButtons]
// - [DateTimePicker]
// - [DatePicker]
// - [TimePicker]
//
// Static widgets:
// - [Label]
// - [HorizontalSeparator]
// - [VerticalSeparator]
// - [ProgressBar]
//
// Buttons:
// - [Button]
// - [ColorButton]
// - [FontButton]
//
///////////////////////////////////////////////////////////////////////////////

/** Represents a GUI control (widget). It provides methods common to all Controls. */
abstract class Control(internal var _ptr: COpaquePointer?) {
    internal val ctl: CPointer<uiControl> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal val ctlDestroy = ctl.pointed.Destroy
    internal val ref = StableRef.create(this)
    init {
        ctl.pointed.Destroy = staticCFunction(::_Destroy)
        controls[ctl] = this
    }
    internal open fun dispose() {
        ref.dispose()
        _ptr = null
    }
}

private var controls = mutableMapOf<CPointer<uiControl>, Control>()

private fun _Destroy(ctl: CPointer<uiControl>?) {
    with (controls[ctl!!] ?: throw Error("Control is destroyed")) {
        ctlDestroy?.invoke(ctl)
        controls.remove(ctl)
        dispose()
    }
}

/** Returns `true` if Control was destroyed - in this case all other operations
 *  are invalid and will `throw Error("Control is destroyed")`. */
val Control.destroyed: Boolean get() = _ptr == null

/** Destroy and free all allocated resources. */
fun Control.destroy() = uiControlDestroy(ctl)

/** Returns the OS-level handle associated with this Control. */
fun Control.getHandle(): Long = uiControlHandle(ctl)

/** Whether the Control is enabled. */
fun Control.isEnabled(): Boolean = uiControlEnabled(ctl) != 0

/** Enables the Control. */
fun Control.enable() = uiControlEnable(ctl)

/** Disables the Control. */
fun Control.disable() = uiControlDisable(ctl)

/** Whether the Control should be enabled or disabled. Defaults to `true`. */
var Control.enabled: Boolean
    get() = isEnabled()
    set(enabled) = if (enabled) enable() else disable()

/** Whether the Control is visible. */
fun Control.isVisible(): Boolean = uiControlVisible(ctl) != 0

/** Shows the Control. */
fun Control.show() = uiControlShow(ctl)

/** Hides the Control. Hidden controls do not participate in layout
 *  (that is, Box, Grid, etc. does not reserve space for hidden controls). */
fun Control.hide() = uiControlHide(ctl)

/** Whether the Control should be visible or hidden. Defaults to `true`. */
var Control.visible: Boolean
    get() = isVisible()
    set(visible) = if (visible) show() else hide()

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form(block: Form.() -> Unit = {}) : Control(uiNewForm()) {
    internal val ptr: CPointer<uiForm> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun Form.add(label: String, widget: Control, stretchy: Boolean = false) =
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid(block: Grid.() -> Unit = {}) : Control(uiNewGrid()) {
    internal val ptr: CPointer<uiGrid> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the Grid. */
fun Grid.add(
    widget: Control,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(ptr, widget.ctl, left, top, xspan, yspan, hexpand, halign, vexpand, valign)

/** Insert the given Control after existing Control. */
fun Grid.insert(
    widget: Control,
    existing: Control,
    at: uiAt,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridInsertAt(ptr, widget.ctl, existing.ctl, at, xspan, yspan, hexpand, halign, vexpand, valign)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(_ptr: CPointer<uiBox>?) : Control(_ptr) {
    internal val ptr: CPointer<uiBox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
}

/** A container that stack its chidren horizontally. */
class HorizontalBox(block: HorizontalBox.() -> Unit = {}) : Box(uiNewHorizontalBox()) {
    init { apply(block) }
}

/** A container that stack its chidren vertically. */
class VerticalBox(block: VerticalBox.() -> Unit = {}) : Box(uiNewVerticalBox()) {
    init { apply(block) }
}

/** If `true`, the container insert some space between children. Defaults to `false`. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the Box. */
fun Box.add(widget: Control, stretchy: Boolean = false) =
    uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)

/** Deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab(block: Tab.() -> Unit = {}) : Control(uiNewTab()) {
    internal val ptr: CPointer<uiTab> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun Tab.add(name: String, widget: Control) = uiTabAppend(ptr, name, widget.ctl)

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insert(index: Int, name: String, widget: Control) = uiTabInsertAt(ptr, name, index, widget.ctl)

/** Delete deletes the nth page of the Tab. */
fun Tab.delete(index: Int) = uiTabDelete(ptr, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(ptr)

///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(text: String, block: Group.() -> Unit = {}) : Control(uiNewGroup(text)) {
    internal val ptr: CPointer<uiGroup> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

/** sets the group's child. If child is null, the group will not have a child. */
fun Group.add(child: Control?) = uiGroupSetChild(ptr, child?.ctl)

///////////////////////////////////////////////////////////////////////////////

/** Single line text entry widget. */
abstract class Entry(_ptr: CPointer<uiEntry>?) : Control(_ptr) {
    internal val ptr: CPointer<uiEntry> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Entry.() -> Unit)? = null
}

/** A simple single line text entry widget. */
class TextEntry(block: Entry.() -> Unit = {}) : Entry(uiNewEntry()) {
    init { apply(block) }
}

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
class PasswordEntry(block: PasswordEntry.() -> Unit = {}) : Entry(uiNewPasswordEntry()) {
    init { apply(block) }
}

/** Text entry widget to search text. */
class SearchEntry(block: SearchEntry.() -> Unit = {}) : Entry(uiNewSearchEntry()) {
    init { apply(block) }
}

/** The current text of the Entry. */
var Entry.value: String
    get() = uiEntryText(ptr)?.toKString() ?: ""
    set(value) = uiEntrySetText(ptr, value)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var Entry.readOnly: Boolean
    get() = uiEntryReadOnly(ptr) != 0
    set(readOnly) = uiEntrySetReadOnly(ptr, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(proc: Entry.() -> Unit) {
    action = proc
    uiEntryOnChanged(ptr, staticCFunction(::_Entry), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Entry(ptr: CPointer<uiEntry>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Entry>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
abstract class MultilineEntry(_ptr: CPointer<uiMultilineEntry>?) : Control(_ptr) {
    internal val ptr: CPointer<uiMultilineEntry> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (MultilineEntry.() -> Unit)? = null
}

/** A wrapping multiline text entry widget. */
class WrappingMultilineEntry(block: MultilineEntry.() -> Unit = {}) :
    MultilineEntry(uiNewMultilineEntry()) {
    init { apply(block) }
}

/** A non wrapping multiline text entry widget. */
class NonWrappingMultilineEntry(block: NonWrappingMultilineEntry.() -> Unit = {}) :
    MultilineEntry(uiNewNonWrappingMultilineEntry()) {
    init { apply(block) }
}

/** The current text of the multiline entry. */
var MultilineEntry.value: String
    get() = uiMultilineEntryText(ptr)?.toKString() ?: ""
    set(value) = uiMultilineEntrySetText(ptr, value)

/** Whether the user is allowed to change the entry text. */
var MultilineEntry.readOnly: Boolean
    get() = uiMultilineEntryReadOnly(ptr) != 0
    set(readOnly) = uiMultilineEntrySetReadOnly(ptr, if (readOnly) 1 else 0)

/** Adds the text to the end of the multiline entry. */
fun MultilineEntry.append(text: String) = uiMultilineEntryAppend(ptr, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun MultilineEntry.action(proc: MultilineEntry.() -> Unit) {
    action = proc
    uiMultilineEntryOnChanged(ptr, staticCFunction(::_MultilineEntry), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _MultilineEntry(ptr: CPointer<uiMultilineEntry>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<MultilineEntry>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
class Checkbox(label: String, block: Checkbox.() -> Unit = {}) : Control(uiNewCheckbox(label)) {
    internal val ptr: CPointer<uiCheckbox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Checkbox.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the checkbox. */
var Checkbox.label: String
    get() = uiCheckboxText(ptr)?.toKString() ?: ""
    set(label) = uiCheckboxSetText(ptr, label)

/** Whether the checkbox is checked or unchecked. Defaults to `false`. */
var Checkbox.value: Boolean
    get() = uiCheckboxChecked(ptr) != 0
    set(value) = uiCheckboxSetChecked(ptr, if (value) 1 else 0)

/** Funcion to be run when the user clicks the Checkbox.
 *  Only one function can be registered at a time. */
fun Checkbox.action(proc: Checkbox.() -> Unit) {
    action = proc
    uiCheckboxOnToggled(ptr, staticCFunction(::_Checkbox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Checkbox(ptr: CPointer<uiCheckbox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Checkbox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
class Combobox(block: Combobox.() -> Unit = {}) : Control(uiNewCombobox()) {
    internal val ptr: CPointer<uiCombobox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Combobox.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named entry to the end of the combobox.
 *  If it is the first entry, it is automatically selected. */
fun Combobox.add(text: String) = uiComboboxAppend(ptr, text)

/** Return or set the current choosed option by index. */
var Combobox.value: Int
    get() = uiComboboxSelected(ptr)
    set(value) = uiComboboxSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(proc: Combobox.() -> Unit) {
    action = proc
    uiComboboxOnSelected(ptr, staticCFunction(::_Combobox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Combobox(ptr: CPointer<uiCombobox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Combobox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
class EditableCombobox(block: EditableCombobox.() -> Unit = {}) : Control(uiNewEditableCombobox()) {
    internal val ptr: CPointer<uiEditableCombobox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (EditableCombobox.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named entry to the end of the editable combobox.
 *  If it is the first entry, it is automatically selected. */
fun EditableCombobox.add(text: String) = uiEditableComboboxAppend(ptr, text)

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.value: String
    get() = uiEditableComboboxText(ptr)?.toKString() ?: ""
    set(value) = uiEditableComboboxSetText(ptr, value)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
    action = proc
    uiEditableComboboxOnChanged(ptr, staticCFunction(::_EditableCombobox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _EditableCombobox(ptr: CPointer<uiEditableCombobox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<EditableCombobox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
class Spinbox(min: Int, max: Int, block: Spinbox.() -> Unit = {}) : Control(uiNewSpinbox(min, max)) {
    internal val ptr: CPointer<uiSpinbox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Spinbox.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the spinbox. */
var Spinbox.value: Int
    get() = uiSpinboxValue(ptr)
    set(value) = uiSpinboxSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Spinbox.
 *  Only one function can be registered at a time. */
fun Spinbox.action(proc: Spinbox.() -> Unit) {
    action = proc
    uiSpinboxOnChanged(ptr, staticCFunction(::_Spinbox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Spinbox(ptr: CPointer<uiSpinbox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Spinbox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
class Slider(min: Int, max: Int, block: Slider.() -> Unit = {}) : Control(uiNewSlider(min, max)) {
    internal val ptr: CPointer<uiSlider> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Slider.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the slider. */
var Slider.value: Int
    get() = uiSliderValue(ptr)
    set(value) = uiSliderSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Slider.
 *  Only one function can be registered at a time. */
fun Slider.action(proc: Slider.() -> Unit) {
    action = proc
    uiSliderOnChanged(ptr, staticCFunction(::_Slider), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Slider(ptr: CPointer<uiSlider>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Slider>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
class RadioButtons(block: RadioButtons.() -> Unit = {}) : Control(uiNewRadioButtons()) {
    internal val ptr: CPointer<uiRadioButtons> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (RadioButtons.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named button to the end of the radiobuttons.
 *  If it is the first button, it is automatically selected. */
fun RadioButtons.add(text: String) = uiRadioButtonsAppend(ptr, text)

/** Return or set the current choosed option by index. */
var RadioButtons.value: Int
    get() = uiRadioButtonsSelected(ptr)
    set(value) = uiRadioButtonsSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
    action = proc
    uiRadioButtonsOnSelected(ptr, staticCFunction(::_RadioButtons), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _RadioButtons(ptr: CPointer<uiRadioButtons>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<RadioButtons>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit date and time. */
abstract class TmPicker(_ptr: CPointer<uiDateTimePicker>?) : Control(_ptr) {
    internal val ptr: CPointer<uiDateTimePicker> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (TmPicker.() -> Unit)? = null
    internal var defaultFormat = "%c"
}

/** A widget to edit date and time. */
class DateTimePicker(block: DateTimePicker.() -> Unit = {}) : TmPicker(uiNewDateTimePicker()) {
    init { apply(block) }
}

/** A widget to edit date. */
class DatePicker(block: DatePicker.() -> Unit = {}) : TmPicker(uiNewDatePicker()) {
    init {
        defaultFormat = "%x"
        apply(block)
    }
}

/** A widget to edit time. */
class TimePicker(block: TimePicker.() -> Unit = {}) : TmPicker(uiNewTimePicker()) {
    init {
        defaultFormat = "%X"
        apply(block)
    }
}

/** The current value as Unix epoch */
var TmPicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>().ptr
       uiDateTimePickerTime(ptr, tm)
       mktime(tm)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       uiDateTimePickerSetTime(ptr, localtime(time.ptr))
    }

/** The current value as String. */
fun TmPicker.textValue(format: String = defaultFormat): String = memScoped {
    var tm = alloc<tm>().ptr
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(ptr, tm)
    strftime(buf, 64, format, tm)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the Picker.
 *  Only one function can be registered at a time. */
fun TmPicker.action(proc: TmPicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(ptr, staticCFunction(::_DateTimePicker), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _DateTimePicker(ptr: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<TmPicker>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
class Label(text: String, block: Label.() -> Unit = {}) : Control(uiNewLabel(text)) {
    internal val ptr: CPointer<uiLabel> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** The static text of the label. */
var Label.value: String
    get() = uiLabelText(ptr)?.toKString() ?: ""
    set(value) = uiLabelSetText(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
abstract class Separator(_ptr: CPointer<uiSeparator>?) : Control(_ptr) {
    internal val ptr: CPointer<uiSeparator> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
}

/** An horizontal line to visually separate widgets. */
class HorizontalSeparator(block: HorizontalSeparator.() -> Unit = {}) : Separator(uiNewHorizontalSeparator()) {
    init { apply(block) }
}

/** A vertical line to visually separate widgets. */
class VerticalSeparator(block: VerticalSeparator.() -> Unit = {}) : Separator(uiNewVerticalSeparator()) {
    init { apply(block) }
}

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
class ProgressBar(block: ProgressBar.() -> Unit = {}) : Control(uiNewProgressBar()) {
    internal val ptr: CPointer<uiProgressBar> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(ptr)
    set(value) = uiProgressBarSetValue(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
class Button(text: String, block: Button.() -> Unit = {}) : Control(uiNewButton(text)) {
    internal val ptr: CPointer<uiButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Button.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the button. */
var Button.text: String
    get() = uiButtonText(ptr)?.toKString() ?: ""
    set(text) = uiButtonSetText(ptr, text)

/** Funcion to be run when the user clicks the Button.
 *  Only one function can be registered at a time. */
fun Button.action(proc: Button.() -> Unit) {
    action = proc
    uiButtonOnClicked(ptr, staticCFunction(::_Button), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Button(ptr: CPointer<uiButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Button>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton(block: ColorButton.() -> Unit = {}) : Control(uiNewColorButton()) {
    internal val ptr: CPointer<uiColorButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (ColorButton.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the currently selected color */
var ColorButton.value: RGBA
    get() = memScoped {
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiColorButtonColor(ptr, r.ptr, g.ptr, b.ptr, a.ptr)
        RGBA(r.value, g.value, b.value, a.value)
    }
    set(value) {
        uiColorButtonSetColor(ptr, value.r, value.g, value.b, value.a)
    }

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(proc: ColorButton.() -> Unit) {
    action = proc
    uiColorButtonOnChanged(ptr, staticCFunction(::_ColorButton), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _ColorButton(ptr: CPointer<uiColorButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<ColorButton>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton(block: FontButton.() -> Unit = {}) : Control(uiNewFontButton()) {
    internal val ptr: CPointer<uiFontButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (FontButton.() -> Unit)? = null
    internal val desc = nativeHeap.alloc<uiFontDescriptor>().ptr
    init { apply(block) }
    override fun dispose() {
        if (desc.pointed.Family != null) desc.destroy()
        nativeHeap.free(desc)
        super.dispose()
    }
}

/** Returns the font currently selected in the FontButton. */
val FontButton.value: FontDescriptor get() {
    if (desc.pointed.Family != null) desc.destroy()
    uiFontButtonFont(ptr, desc)
    return desc
}

/** Funcion to be run when the font in the FontButton is changed.
 *  Only one function can be registered at a time. */
fun FontButton.action(proc: FontButton.() -> Unit) {
    action = proc
    uiFontButtonOnChanged(ptr, staticCFunction(::_FontButton), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _FontButton(ptr: CPointer<uiFontButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<FontButton>().get()) {
        action?.invoke(this)
    }
}
