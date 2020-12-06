package com.example.demo.app

import com.example.demo.view.*
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*


class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage) {
        with(stage){
            minWidth =360.0
            minHeight =600.0
        }

        stage.icons += Image("/logoNeu.png")

        super.start(stage)
    }
init{
    reloadStylesheetsOnFocus()
    reloadViewsOnFocus()
}

}