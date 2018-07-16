[libui.ktx](../index.md) / [TimePicker](./index.md)

# TimePicker

`class TimePicker : `[`DateTimePicker`](../-date-time-picker/index.md)

Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit time.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TimePicker()`<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit time. |

### Inherited Properties

| Name | Summary |
|---|---|
| [value](../-date-time-picker/value.md) | `var value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The current value in Unix epoch |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-date-time-picker/action.md) | `fun action(block: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be run when the user makes a change to the Picker. Only one function can be registered at a time. |
| [getValue](../-date-time-picker/get-value.md) | `fun getValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The current value as posix `struct tm` |
| [setValue](../-date-time-picker/set-value.md) | `fun setValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set current value from posix `struct tm` |
| [textValue](../-date-time-picker/text-value.md) | `fun textValue(format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = defaultFormat): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The current value as String. |