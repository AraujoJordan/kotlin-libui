[libui.ktx](./index.md)

## Package libui.ktx

### Types

| Name | Summary |
|---|---|
| [Attribute](-attribute/index.md) | `abstract class Attribute : `[`Disposable`](-disposable/index.md)`<`[`uiAttribute`](../libui/ui-attribute.md)`>`<br>Stores information about an attribute in a [string](string.md). |
| [AttributedString](-attributed-string/index.md) | `class AttributedString : `[`Disposable`](-disposable/index.md)`<`[`uiAttributedString`](../libui/ui-attributed-string.md)`>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [BackgroundAttribute](-background-attribute/index.md) | `class BackgroundAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the background color of the text it is applied to. |
| [Box](-box/index.md) | `abstract class Box : `[`Control`](-control/index.md)`<`[`uiBox`](../libui/ui-box.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) |
| [Brush](-brush/index.md) | `class Brush : `[`Disposable`](-disposable/index.md)`<`[`uiDrawBrush`](../libui/ui-draw-brush/index.md)`>`<br>Defines the color(s) to draw a path with. |
| [Button](-button/index.md) | `class Button : `[`Control`](-control/index.md)`<`[`uiButton`](../libui/ui-button.md)`>`<br>Wrapper class for [uiButton](../libui/ui-button.md) |
| [Checkbox](-checkbox/index.md) | `class Checkbox : `[`Control`](-control/index.md)`<`[`uiCheckbox`](../libui/ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../libui/ui-checkbox.md) |
| [Color](-color/index.md) | `data class Color` |
| [ColorAttribute](-color-attribute/index.md) | `class ColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the text it is applied to. |
| [ColorButton](-color-button/index.md) | `class ColorButton : `[`Control`](-control/index.md)`<`[`uiColorButton`](../libui/ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../libui/ui-color-button.md) |
| [Combobox](-combobox/index.md) | `class Combobox : `[`Control`](-control/index.md)`<`[`uiCombobox`](../libui/ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../libui/ui-combobox.md) |
| [Container](-container/index.md) | `interface Container`<br>Container for child controls. |
| [Control](-control/index.md) | `abstract class Control<T : CPointed> : `[`Disposable`](-disposable/index.md)`<`[`T`](-control/index.md#T)`>`<br>Base class for all GUI controls (widgets). |
| [DatePicker](-date-picker/index.md) | `class DatePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit date. |
| [DateTimePicker](-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](-control/index.md)`<`[`uiDateTimePicker`](../libui/ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit date and time. |
| [Disposable](-disposable/index.md) | `abstract class Disposable<T : CPointed>`<br>Manages and owns all its native resources. |
| [DrawArea](-draw-area/index.md) | `open class DrawArea : `[`Control`](-control/index.md)`<`[`uiArea`](../libui/ui-area.md)`>`<br>Wrapper class for [uiArea](../libui/ui-area.md) |
| [EditableCombobox](-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](-control/index.md)`<`[`uiEditableCombobox`](../libui/ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../libui/ui-editable-combobox.md) |
| [FamilyAttribute](-family-attribute/index.md) | `class FamilyAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the font family of the text it is applied to. |
| [FeaturesAttribute](-features-attribute/index.md) | `class FeaturesAttribute : `[`Attribute`](-attribute/index.md)<br>Creates a new Attribute that changes the font family of the text it is applied to. otf is copied you may free it after uiNewFeaturesAttribute() returns. |
| [Font](-font/index.md) | `class Font : `[`Disposable`](-disposable/index.md)`<`[`uiFontDescriptor`](../libui/ui-font-descriptor/index.md)`>`<br>Provides a complete description of a font where one is needed. |
| [FontButton](-font-button/index.md) | `class FontButton : `[`Control`](-control/index.md)`<`[`uiFontButton`](../libui/ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../libui/ui-font-button.md) |
| [Form](-form/index.md) | `class Form : `[`Control`](-control/index.md)`<`[`uiForm`](../libui/ui-form.md)`>`<br>Wrapper class for [uiForm](../libui/ui-form.md) |
| [GridPane](-grid-pane/index.md) | `class GridPane : `[`Control`](-control/index.md)`<`[`uiGrid`](../libui/ui-grid.md)`>`<br>Wrapper class for [uiGrid](../libui/ui-grid.md) |
| [Group](-group/index.md) | `class Group : `[`Control`](-control/index.md)`<`[`uiGroup`](../libui/ui-group.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiGroup](../libui/ui-group.md) |
| [HBox](-h-box/index.md) | `class HBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) that stack its children horizontally. |
| [HorizontalSeparator](-horizontal-separator/index.md) | `class HorizontalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) in VBox |
| [Image](-image/index.md) | `class Image : `[`Disposable`](-disposable/index.md)`<`[`uiImage`](../libui/ui-image.md)`>` |
| [ImageData](-image-data/index.md) | `class ImageData` |
| [ItalicAttribute](-italic-attribute/index.md) | `class ItalicAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the italic mode of the text it is applied to. |
| [Label](-label/index.md) | `class Label : `[`Control`](-control/index.md)`<`[`uiLabel`](../libui/ui-label.md)`>`<br>Wrapper class for [uiLabel](../libui/ui-label.md) |
| [Matrix](-matrix/index.md) | `class Matrix : `[`Disposable`](-disposable/index.md)`<`[`uiDrawMatrix`](../libui/ui-draw-matrix/index.md)`>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](-open-type-features/index.md) | `class OpenTypeFeatures : `[`Disposable`](-disposable/index.md)`<`[`uiOpenTypeFeatures`](../libui/ui-open-type-features.md)`>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [PasswordField](-password-field/index.md) | `class PasswordField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) to edit passwords. |
| [Path](-path/index.md) | `class Path : `[`Disposable`](-disposable/index.md)`<`[`uiDrawPath`](../libui/ui-draw-path.md)`>`<br>Represent a path that could be drawed on a [DrawContext](-draw-context.md) |
| [Point](-point/index.md) | `data class Point` |
| [ProgressBar](-progress-bar/index.md) | `class ProgressBar : `[`Control`](-control/index.md)`<`[`uiProgressBar`](../libui/ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../libui/ui-progress-bar.md) |
| [RadioButtons](-radio-buttons/index.md) | `class RadioButtons : `[`Control`](-control/index.md)`<`[`uiRadioButtons`](../libui/ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../libui/ui-radio-buttons.md) |
| [ScrollingArea](-scrolling-area/index.md) | `class ScrollingArea : `[`DrawArea`](-draw-area/index.md)<br>Wrapper class for [uiArea](../libui/ui-area.md) with scrollbars. |
| [SearchField](-search-field/index.md) | `class SearchField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) to search text. |
| [Separator](-separator/index.md) | `abstract class Separator : `[`Control`](-control/index.md)`<`[`uiSeparator`](../libui/ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) |
| [Size](-size/index.md) | `data class Size` |
| [SizeAttribute](-size-attribute/index.md) | `class SizeAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the size of the text it is applied to, in typographical points. |
| [SizeInt](-size-int/index.md) | `data class SizeInt` |
| [Slider](-slider/index.md) | `class Slider : `[`Control`](-control/index.md)`<`[`uiSlider`](../libui/ui-slider.md)`>`<br>Wrapper class for [uiSlider](../libui/ui-slider.md) |
| [Spinbox](-spinbox/index.md) | `class Spinbox : `[`Control`](-control/index.md)`<`[`uiSpinbox`](../libui/ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../libui/ui-spinbox.md) |
| [StretchAttribute](-stretch-attribute/index.md) | `class StretchAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the stretch of the text it is applied to. |
| [Stroke](-stroke/index.md) | `class Stroke : `[`Disposable`](-disposable/index.md)`<`[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`>`<br>Describes the stroke to draw with. |
| [TabPane](-tab-pane/index.md) | `class TabPane : `[`Control`](-control/index.md)`<`[`uiTab`](../libui/ui-tab.md)`>`<br>Wrapper class for [uiTab](../libui/ui-tab.md) |
| [Table](-table/index.md) | `class Table<T> : `[`Disposable`](-disposable/index.md)`<`[`uiTableModel`](../libui/ui-table-model.md)`>`<br>Wrapper class for [uiTableModel](../libui/ui-table-model.md) |
| [TableView](-table-view/index.md) | `class TableView : `[`Control`](-control/index.md)`<`[`uiTable`](../libui/ui-table.md)`>`<br>Wrapper class for [uiTable](../libui/ui-table.md) |
| [TextArea](-text-area/index.md) | `class TextArea : `[`Control`](-control/index.md)`<`[`uiMultilineEntry`](../libui/ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../libui/ui-multiline-entry.md) |
| [TextField](-text-field/index.md) | `open class TextField : `[`Control`](-control/index.md)`<`[`uiEntry`](../libui/ui-entry.md)`>`<br>Wrapper class for [uiEntry](../libui/ui-entry.md) |
| [TextLayout](-text-layout/index.md) | `class TextLayout : `[`Disposable`](-disposable/index.md)`<`[`uiDrawTextLayout`](../libui/ui-draw-text-layout.md)`>`<br>Representation of a [string](string.md) that can be displayed in a [DrawContext](-draw-context.md). |
| [TimePicker](-time-picker/index.md) | `class TimePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit time. |
| [UnderlineAttribute](-underline-attribute/index.md) | `class UnderlineAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the type of underline on the text it is applied to. |
| [UnderlineColorAttribute](-underline-color-attribute/index.md) | `class UnderlineColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the underline on the text it is applied to. |
| [VBox](-v-box/index.md) | `class VBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) that stack its children vertically. |
| [VerticalSeparator](-vertical-separator/index.md) | `class VerticalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) in HBox |
| [WeightAttribute](-weight-attribute/index.md) | `class WeightAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the weight of the text it is applied to. |
| [Window](-window/index.md) | `class Window : `[`Control`](-control/index.md)`<`[`uiWindow`](../libui/ui-window.md)`>, `[`Container`](-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |

### Type Aliases

| Name | Summary |
|---|---|
| [DrawContext](-draw-context.md) | `typealias DrawContext = CPointer<`[`uiDrawContext`](../libui/ui-draw-context.md)`>` |
| [Menu](-menu.md) | `typealias Menu = CPointer<`[`uiMenu`](../libui/ui-menu.md)`>` |
| [MenuItem](-menu-item.md) | `typealias MenuItem = CPointer<`[`uiMenuItem`](../libui/ui-menu-item.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [hbox](hbox.md) | `val `[`Container`](-container/index.md)`.hbox: `[`HBox`](-h-box/index.md) |
| [stretchy](stretchy.md) | `val `[`Box`](-box/index.md)`.stretchy: `[`Stretchy`](-box/-stretchy/index.md)<br>`val `[`Form`](-form/index.md)`.stretchy: `[`Stretchy`](-form/-stretchy/index.md) |
| [vbox](vbox.md) | `val `[`Container`](-container/index.md)`.vbox: `[`VBox`](-v-box/index.md) |

### Functions

| Name | Summary |
|---|---|
| [Color](-color.md) | `fun Color(rgb: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, alpha: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0): `[`Color`](-color/index.md) |
| [MsgBox](-msg-box.md) | `fun MsgBox(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, details: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = ""): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a modal Message Box. |
| [MsgBoxError](-msg-box-error.md) | `fun MsgBoxError(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, details: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = ""): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a modal Error Message Box. |
| [OpenFileDialog](-open-file-dialog.md) | `fun OpenFileDialog(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Displays a modal Open File Dialog. |
| [SaveFileDialog](-save-file-dialog.md) | `fun SaveFileDialog(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Displays a modal Save File Dialog. |
| [appWindow](app-window.md) | `fun appWindow(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Window`](-window/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initializes package ui, runs [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) to set up the program, and executes the GUI main loop. [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) should set up the program's initial state: open the main window, create controls, and set up events. |
| [bitmap](bitmap.md) | `fun `[`Image`](-image/index.md)`.bitmap(data: `[`ImageData`](-image-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [brush](brush.md) | `fun `[`DrawArea`](-draw-area/index.md)`.brush(): `[`Brush`](-brush/index.md)<br>Creates a new Brush with lifecycle delegated to DrawArea. |
| [button](button.md) | `fun `[`Container`](-container/index.md)`.button(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Button`](-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Button`](-button/index.md)<br>A simple button. |
| [cell](cell.md) | `fun `[`GridPane`](-grid-pane/index.md)`.cell(x: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, y: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, xspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, hexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, halign: `[`uiAlign`](../libui/ui-align.md)` = uiAlignFill, vexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, valign: `[`uiAlign`](../libui/ui-align.md)` = uiAlignFill): `[`Cell`](-grid-pane/-cell/index.md) |
| [checkbox](checkbox.md) | `fun `[`Container`](-container/index.md)`.checkbox(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Checkbox`](-checkbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Checkbox`](-checkbox/index.md)<br>A checkbox widget. |
| [colorbutton](colorbutton.md) | `fun `[`Container`](-container/index.md)`.colorbutton(init: `[`ColorButton`](-color-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ColorButton`](-color-button/index.md)<br>A button that opens a color palette popup. |
| [combobox](combobox.md) | `fun `[`Container`](-container/index.md)`.combobox(init: `[`Combobox`](-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Combobox`](-combobox/index.md)<br>A drop down combo box that allow list selection only. |
| [datepicker](datepicker.md) | `fun `[`Container`](-container/index.md)`.datepicker(init: `[`DatePicker`](-date-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DatePicker`](-date-picker/index.md)<br>A widget to edit date. |
| [datetimepicker](datetimepicker.md) | `fun `[`Container`](-container/index.md)`.datetimepicker(init: `[`DateTimePicker`](-date-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DateTimePicker`](-date-time-picker/index.md)<br>A widget to edit date and time. |
| [drawarea](drawarea.md) | `fun `[`Container`](-container/index.md)`.drawarea(init: `[`DrawArea`](-draw-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DrawArea`](-draw-area/index.md)<br>A canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](editablecombobox.md) | `fun `[`Container`](-container/index.md)`.editablecombobox(init: `[`EditableCombobox`](-editable-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`EditableCombobox`](-editable-combobox/index.md)<br>A drop down combo box that allow selection from list or free text entry. |
| [field](field.md) | `fun `[`Form`](-form/index.md)`.field(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Field`](-form/-field/index.md)<br>`fun `[`Stretchy`](-form/-stretchy/index.md)`.field(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Field`](-form/-stretchy/-field/index.md) |
| [fill](fill.md) | `fun `[`DrawContext`](-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Draw a path filled with a color.`fun `[`DrawContext`](-draw-context.md)`.fill(brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [fontbutton](fontbutton.md) | `fun `[`Container`](-container/index.md)`.fontbutton(init: `[`FontButton`](-font-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`FontButton`](-font-button/index.md)<br>A button that allows users to choose a font when they click on it. |
| [form](form.md) | `fun `[`Container`](-container/index.md)`.form(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Form`](-form/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Form`](-form/index.md)<br>A container that organize children as labeled fields. |
| [gridpane](gridpane.md) | `fun `[`Container`](-container/index.md)`.gridpane(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`GridPane`](-grid-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`GridPane`](-grid-pane/index.md)<br>A powerful container that allow to specify size and position of each children. |
| [group](group.md) | `fun `[`Container`](-container/index.md)`.group(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Group`](-group/index.md)<br>A container for a single widget that provide a caption and visually group it's children. |
| [hbox](hbox.md) | `fun `[`Container`](-container/index.md)`.hbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`HBox`](-h-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`HBox`](-h-box/index.md)<br>A container that stack its children horizontally. |
| [image](image.md) | `fun `[`Table`](-table/index.md)`<*>.image(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, block: `[`Image`](-image/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Image`](-image/index.md) |
| [label](label.md) | `fun `[`Container`](-container/index.md)`.label(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Label`](-label/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Label`](-label/index.md)<br>A static text label. |
| [onShouldQuit](on-should-quit.md) | `fun onShouldQuit(block: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be executed when the OS wants the program to quit or when a Quit menu item has been clicked. Only one function may be registered at a time. |
| [onTimer](on-timer.md) | `fun onTimer(milliseconds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, block: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be executed on a timer on the main thread. |
| [page](page.md) | `fun `[`TabPane`](-tab-pane/index.md)`.page(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Page`](-tab-pane/-page/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Page`](-tab-pane/-page/index.md) |
| [passwordfield](passwordfield.md) | `fun `[`Container`](-container/index.md)`.passwordfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`PasswordField`](-password-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`PasswordField`](-password-field/index.md)<br>Text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](progressbar.md) | `fun `[`Container`](-container/index.md)`.progressbar(init: `[`ProgressBar`](-progress-bar/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ProgressBar`](-progress-bar/index.md)<br>Progress bar widget. |
| [radiobuttons](radiobuttons.md) | `fun `[`Container`](-container/index.md)`.radiobuttons(init: `[`RadioButtons`](-radio-buttons/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`RadioButtons`](-radio-buttons/index.md)<br>A widget that represent a group of radio options. |
| [random](random.md) | `fun random(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [scrollingarea](scrollingarea.md) | `fun `[`Container`](-container/index.md)`.scrollingarea(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`ScrollingArea`](-scrolling-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ScrollingArea`](-scrolling-area/index.md)<br>[DrawArea](-draw-area/index.md) with horziontal and vertical scrollbars. |
| [searchfield](searchfield.md) | `fun `[`Container`](-container/index.md)`.searchfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`SearchField`](-search-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`SearchField`](-search-field/index.md)<br>Text entry widget to search text. |
| [separator](separator.md) | `fun `[`VBox`](-v-box/index.md)`.separator(init: `[`HorizontalSeparator`](-horizontal-separator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`HorizontalSeparator`](-horizontal-separator/index.md)<br>An horizontal line to visually separate widgets.`fun `[`HBox`](-h-box/index.md)`.separator(init: `[`VerticalSeparator`](-vertical-separator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`VerticalSeparator`](-vertical-separator/index.md)<br>A vertical line to visually separate widgets. |
| [slider](slider.md) | `fun `[`Container`](-container/index.md)`.slider(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Slider`](-slider/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Slider`](-slider/index.md)<br>Horizontal slide to set numerical values. |
| [spinbox](spinbox.md) | `fun `[`Container`](-container/index.md)`.spinbox(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Spinbox`](-spinbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Spinbox`](-spinbox/index.md)<br>An entry widget for numerical values. |
| [stretchy](stretchy.md) | `fun `[`Box`](-box/index.md)`.stretchy(init: `[`Stretchy`](-box/-stretchy/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Stretchy`](-box/-stretchy/index.md) |
| [string](string.md) | `fun `[`DrawArea`](-draw-area/index.md)`.string(init: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`AttributedString`](-attributed-string/index.md)<br>Creates a new AttributedString from initial String. The string will be entirely unattributed. |
| [stroke](stroke.md) | `fun `[`DrawArea`](-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Stroke`](-stroke/index.md)<br>Creates a new Stroke with lifecycle delegated to DrawArea.`fun `[`DrawContext`](-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Draw a path in the context.`fun `[`DrawContext`](-draw-context.md)`.stroke(brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [table](table.md) | `fun <T> table(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](table.md#T)`>): `[`Table`](-table/index.md)`<`[`T`](table.md#T)`>` |
| [tableview](tableview.md) | `fun <T> `[`Container`](-container/index.md)`.tableview(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](tableview.md#T)`>, init: `[`Table`](-table/index.md)`<`[`T`](tableview.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TableView`](-table-view/index.md) |
| [tabpane](tabpane.md) | `fun `[`Container`](-container/index.md)`.tabpane(init: `[`TabPane`](-tab-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TabPane`](-tab-pane/index.md)<br>A container that show each children in a separate tab. |
| [text](text.md) | `fun `[`DrawContext`](-draw-context.md)`.text(string: `[`AttributedString`](-attributed-string/index.md)`, defaultFont: `[`Font`](-font/index.md)`, width: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, align: `[`uiDrawTextAlign`](../libui/ui-draw-text-align.md)`, x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>draws formatted text with the top-left point at ([x](text.md#libui.ktx$text(kotlinx.cinterop.CPointer((kotlinx.cinterop.CPointed)), libui.ktx.AttributedString, libui.ktx.Font, kotlin.Double, kotlin.Int, kotlin.Double, kotlin.Double)/x), [y](text.md#libui.ktx$text(kotlinx.cinterop.CPointer((kotlinx.cinterop.CPointed)), libui.ktx.AttributedString, libui.ktx.Font, kotlin.Double, kotlin.Int, kotlin.Double, kotlin.Double)/y)). |
| [textarea](textarea.md) | `fun `[`Container`](-container/index.md)`.textarea(wrap: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextArea`](-text-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TextArea`](-text-area/index.md)<br>A multiline plain text editing widget. |
| [textfield](textfield.md) | `fun `[`Container`](-container/index.md)`.textfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextField`](-text-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TextField`](-text-field/index.md)<br>A simple single line text entry widget. |
| [timepicker](timepicker.md) | `fun `[`Container`](-container/index.md)`.timepicker(init: `[`TimePicker`](-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TimePicker`](-time-picker/index.md)<br>A widget to edit time. |
| [transform](transform.md) | `fun `[`DrawContext`](-draw-context.md)`.transform(block: `[`Matrix`](-matrix/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Apply a different transform matrix to the context. |
| [vbox](vbox.md) | `fun `[`Container`](-container/index.md)`.vbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`VBox`](-v-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`VBox`](-v-box/index.md)<br>A container that stack its children vertically. |