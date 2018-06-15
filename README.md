kotlin-libui
============

[Kotlin/Native](https://github.com/JetBrains/kotlin-native) bindings to the
[libui](https://github.com/andlabs/libui.git) C library.

[![Build Status](https://travis-ci.org/msink/kotlin-libui.svg?branch=master)](https://travis-ci.org/msink/kotlin-libui)
[![Build status](https://ci.appveyor.com/api/projects/status/github/msink/kotlin-libui?svg=true)](https://ci.appveyor.com/project/msink/kotlin-libui)

libui is a C lightweight multi-platform UI library using native widgets on Linux (Gtk3), macOS, and Windows.
Using this bindings you can develop cross-platform but native-looking GUI programs, written in Kotlin,
and compiled to small native executable file.

Cross-platform build is automated using [Travis](https://travis-ci.org) for Linux and macOS targets, and
[AppVeyor](https://ci.appveyor.com) for Windows targets. Just create release on GitHub, and executable files
for all 3 major desktop platforms will be compiled and attached to release.

For local build use `./build.sh` on Linux or macOS, or `build.bat` on Windows.
In this case only one - native for your platform - file will be built.

## Hello World

Let's start from minimal sample application - single button and single scrollable text area.

<details>
 <summary>Screenshots:</summary>

![Windows](samples/hello/hello-windows.png)

![Unix](samples/hello/hello-linux.png)

![macOS](samples/hello/hello-osx.png)
</details><br/>

<details>
 <summary>C implementation:</summary>
    
``` c
#include "ui.h"

static int onClosing(uiWindow *window, void *data)
{
    uiQuit();
    return 1;
}

static void saySomething(uiButton *button, void *data)
{
    uiMultilineEntryAppend(uiMultilineEntry(data),
        "Hello, World!  Ciao, mondo!\n"
        "Привет, мир!  你好，世界！\n\n");
}

int main(void)
{
    uiInitOptions options;
    uiWindow *window;
    uiBox *box;
    uiButton *button;
    uiMultilineEntry *scroll;

    memset(&options, 0, sizeof(options));
    if (uiInit(&options) != NULL)
        abort();

    window = uiNewWindow("Hello", 320, 240, 0);
    uiWindowSetMargined(window, 1);

    box = uiNewVerticalBox();
    uiBoxSetPadded(box, 1);
    uiWindowSetChild(window, uiControl(box));

    scroll = uiNewMultilineEntry();
    uiMultilineEntrySetReadOnly(scroll, 1);

    button = uiNewButton("libui говорит: click me!");
    uiButtonOnClicked(button, saySomething, scroll);
    uiBoxAppend(box, uiControl(button), 0);

    uiBoxAppend(box, uiControl(scroll), 1);

    uiWindowOnClosing(window, onClosing, NULL);
    uiControlShow(uiControl(window));
    uiMain();
    return 0;
}
```
</details><br/>

<details>
 <summary>Direct translation to Kotlin:</summary>
    
``` kt
import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = memScoped {
    val options = alloc<uiInitOptions>()
    val error = uiInit(options.ptr)
    if (error != null) throw Error("Error: '${error.toKString()}'")

    val window = uiNewWindow("Hello", 320, 240, 0)
    uiWindowSetMargined(window, 1)

    val box = uiNewVerticalBox()
    uiBoxSetPadded(box, 1)
    uiWindowSetChild(window, box?.reinterpret())

    val scroll = uiNewMultilineEntry()
    uiMultilineEntrySetReadOnly(scroll, 1)
    val button = uiNewButton("libui говорит: click me!")
    fun saySomething(button: CPointer<uiButton>?, data: COpaquePointer?) {
        uiMultilineEntryAppend(data?.reinterpret(),
            "Hello, World!  Ciao, mondo!\n" +
            "Привет, мир!  你好，世界！\n\n")
    }
    uiButtonOnClicked(button, staticCFunction(::saySomething), scroll)
    uiBoxAppend(box, button?.reinterpret(), 0)
    uiBoxAppend(box, scroll?.reinterpret(), 1)

    fun onClosing(window: CPointer<uiWindow>?, data: COpaquePointer?): Int {
        uiQuit()
        return 1
    }
    uiWindowOnClosing(window, staticCFunction(::onClosing), null)
    uiControlShow(window?.reinterpret())
    uiMain()
    uiUninit()
}
```
</details><br/>

While this works, it's far from ideomatic Kotlin.

<details>
 <summary>A little improved version, with thin wrappers around raw libui procedures:</summary>

``` kt
import libui.*

fun main(args: Array<String>) = libuiApplication {
    Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false) {
        margined = true

        add(VerticalBox {
            padded = true
            val scroll = WrappingMultilineEntry {
                readOnly = true
            }
            val button = Button("libui говорит: click me!") {
                action {
                    scroll.append("Hello, World!  Ciao, mondo!\n" +
                                  "Привет, мир!  你好，世界！\n\n")
                }
            }
            add(button)
            add(scroll, stretchy = true)
        })

        onClose { uiQuit(); true }
        show()
    }
}
```
</details><br/>

It's still not real DSL, but much better.

## More samples

- [simple form](samples/form)
- [controls gallery](samples/controlgallery)
- [histogram](samples/histogram)
- [drawtext](samples/drawtext)
- [datetime](samples/datetime)

## Work in progress!

There still is wide area for kotlinization.

If anyone have ideas how to make this more ideomatic - Issues and PullRequests are welcome.
