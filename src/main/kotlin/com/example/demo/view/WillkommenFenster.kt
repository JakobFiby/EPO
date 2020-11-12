package com.example.demo.view

import com.example.demo.app.Styles
import tornadofx.*

class WillkommenFenster: App(MainView::class, Styles::class) {
    init{
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }
}