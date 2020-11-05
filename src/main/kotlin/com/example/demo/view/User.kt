package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject
import java.sql.*

class User : JsonModel {
    val nameProperty = SimpleStringProperty()
    var name by nameProperty

    override fun updateModel(json: JsonObject) {
        with(json){
            name= string("name")
        }
    }
}

class UserModel : ItemViewModel<User>() {
    val name = bind(User::nameProperty)

    fun main(Args: Array<String>)
    {
        
    }
}
