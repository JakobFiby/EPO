package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException
import com.example.demo.app.Styles
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

object EinstellungenController {

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
    var nutzernamen = ArrayList<String>()
    var nnvorhanden = false

    fun abmelden(){
        abmelden="1"
        val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
    }//ende abmelden()

    fun anmelden(){
        abmelden="0"
        val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
    }//ende anmelden()

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
    }//ende farbschemaaendern()

    fun profil(profil: String, andern: String, JaNein: Boolean){
        try {
            userId=LoginController.userId
            profilopt =profil
            andernaufruf=andern
            andernJaNein=JaNein

            val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val json = r.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                nnTest = jo.get("nutzername").toString()
                nutzernamen.add(nnTest)

                if(nnTest.equals(LoginController.username)){
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
                if(profil.equals("Nutzername")){
                    if(nutzernamen.contains(andernaufruf)){
                        nnvorhanden = true
                        nutzernamen.clear()
                    }
                    else {
                        val pro = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateUser?userid=${userId}&nutzername=${andernaufruf}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                        LoginController.username = andernaufruf
                        nn = andernaufruf
                        nutzernamen.clear()
                    }
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
            }//ende if gesamt aenderung
            andernJaNein=false
            if(farbschemaid.equals("1")){
                farbmodus="Tagmodus"
            }
            if(farbschemaid.equals("2")){
                farbmodus="Nachtmodus"
            }
        } //ende try
        catch (e: SQLException){
            e.printStackTrace()
        } //ende catch
    }//ende profil()
}