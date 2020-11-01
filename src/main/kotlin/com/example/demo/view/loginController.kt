package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class LoginController:Controller(){

    val statusProperty=SimpleStringProperty()
    var status by statusProperty
    val user:UserModel by inject()

    val api:Rest by inject()

    init{
        api.baseURI="https://api.github.com/"
    }
    fun login(nutzername: String, passwort: String) {
        runLater{status=""}
        api.setBasicAuth(nutzername, passwort)
        val antwort=api.get("user")
        val json=antwort.one()
        runLater{
            if(antwort.ok()){
                user.item=json.toModel()
                find(LoginFenster::class).replaceWith(UeberblickFenster::class, sizeToScene=true,centerOnScreen=true)
                }
            else{
                status=json.string("Nachricht")?:"Login hat nicht funktioniert"
            }
        }
    }
    fun logout(){
        user.item=null
        primaryStage.uiComponent<UIComponent>()?.replaceWith(LoginFenster::class,sizeToScene=true,centerOnScreen=true)
    }

}



