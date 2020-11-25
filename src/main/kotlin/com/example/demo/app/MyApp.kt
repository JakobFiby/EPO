package com.example.demo.app

import com.example.demo.view.*
import javafx.stage.Stage
import tornadofx.*


class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage) {
        with(stage){
            width=360.0
            height=600.0
        }
        super.start(stage)
    }
init{
    reloadStylesheetsOnFocus()
    reloadViewsOnFocus()
}

}