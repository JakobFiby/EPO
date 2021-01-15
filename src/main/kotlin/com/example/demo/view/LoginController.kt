package com.example.demo.view

import com.google.gson.Gson
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException

object LoginController{

    var nn: String = ""
    var pw: String = ""
    var id: String = ""
    var nnB: Boolean = false
    var pwB: Boolean = false
    var userId: Int = 0
    var abmelden:String =""
    public var username: String = ""
    public var working: Boolean = false

    fun eingeloggt(){
        val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
        val json = request.jsonArray
        for (ja in json) {
            val jo = ja as JSONObject
            abmelden = jo.get("abmelden").toString()
        }//ende for

    } //ende eingeloggt()

    fun login(nutzername: String, passwort: String) {

        try {
            val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val json = request.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                nn = jo.get("nutzername").toString()
                pw = jo.get("passwort").toString()
                id = jo.get("userid").toString()

                //Passwort hashen
                var pwhash = passwort.sha256()
                if (pwhash.length == 63) {
                    pwhash = "0" + pwhash
                }

                //Login-Überprüfung
                //Nutzername überprüfen
                if (nn.equals(nutzername)) {
                    nnB = true
                    userId = id.toInt()
                    username = nn
                }

                //Passwort überprüfen
                if (pw.equals(pwhash)) {
                    pwB = true
                }
            }//ende for

            if (pwB == true && nnB == true) {
                working = true
            } else {
                println("Nutzername und/oder Passwort sind nicht richtig")
                LoginView().onDock()
            }
        }//ende try
        catch (e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende login()

    //Hashen
    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }//ende sha256()

}

