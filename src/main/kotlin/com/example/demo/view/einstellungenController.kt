package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object einstellungenController {

    var nnTest: String = ""
    var nn: String = ""
    var pw: String = ""
    var id: String = ""
    var vn: String = ""
    var nachn: String = ""
    var email: String = ""
    var abmelden: String = ""
    var farbschemaid: String = ""
    var userId: Int = 0
    var profilopt: String = ""
    var andernaufruf:String=""
    var andernJaNein: Boolean = false
    var farbmodus:String =""

    fun abmelden(){
        abmelden="1"
        val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${andernaufruf}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
    }
    fun anmelden(){
        abmelden="0"
        val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${andernaufruf}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
    }
    fun farbschemaaendern(farbmod:String){
        if(farbmod.equals("Nachtmodus")){
            farbmodus="Tagmodus"
            farbschemaid="1"
            val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
        }
        if(farbmod.equals("Tagmodus")){
            farbmodus="Nachtmodus"
            farbschemaid="2"
            val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
        }
    }

    fun profil(profil: String, andern: String, JaNein: Boolean){
        try {
            userId=loginController.userId
            profilopt =profil
            andernaufruf=andern
            andernJaNein=JaNein

            val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val json = r.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                nnTest = jo.get("nutzername").toString()
                if(nnTest.equals(loginController.username)){
                    nn = jo.get("nutzername").toString()
                    vn = jo.get("vorname").toString()
                    nachn = jo.get("nachname").toString()
                    email = jo.get("email").toString()
                    pw = jo.get("passwort").toString()
                    id = jo.get("userid").toString()
                    farbschemaid=jo.get("farbschemaid").toString()
                    abmelden=jo.get("abmelden").toString()
                }
            }

            if(andernJaNein==true){
                println("Änderung erfolgt")
                if(profil.equals("Nutzername")){
                    val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${andernaufruf}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    nn= andernaufruf
                }
                if(profil.equals("Vorname")){
                    val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${andernaufruf}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    vn= andernaufruf
                }
                if(profil.equals("Nachname")){
                    val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${andernaufruf}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    nachn= andernaufruf
                }
                if(profil.equals("Email")){
                    val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${andernaufruf}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    email= andernaufruf
                }
            }
            andernJaNein=false

            if(farbschemaid.equals("1")){
                farbmodus="Tagmodus"
            }
            if(farbschemaid.equals("2")){
                farbmodus="Nachtmodus"
            }
        }
        catch (e: SQLException){
            e.printStackTrace()
        }
    }
}