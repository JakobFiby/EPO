package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject
import tornadofx.getValue
import tornadofx.setValue


class User : JsonModel {
    val nameProperty = SimpleStringProperty()
    var name by nameProperty
    var pwname by nameProperty
    var nnname by nameProperty

    override fun updateModel(json: JsonObject) {
        with(json){
            name= string("name")
            pwname=string("passwort")
            nnname=string("nutzername")
        }
    }
}

class UserModel : ItemViewModel<User>() {
    val name = bind(User::nameProperty)
    val pwname = bind(User::nameProperty)
    val nnname = bind(User::nameProperty)
}
