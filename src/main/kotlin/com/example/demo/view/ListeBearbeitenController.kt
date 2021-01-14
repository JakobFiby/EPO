package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object ListeBearbeitenController {
    @JvmStatic

    var userid:String = ""
    var user:String = ""
    var uid:String = ""
    var gefunden = ArrayList<String>()
    var listeName:String = ""
    var ln = ""
    var li = ""
    var listeid = ""
    var UID = ""
    var LID = ""
    var anlegen:Boolean = true
    var text:Int = 0
    var gf = false
    var angemeldterUser = LoginController.userId

    fun getName(aListe:String){
        listeName = aListe
    }//ende getName()

    fun userhinzufügen(name:String){
        try{
        gefunden.clear()
        
        val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
        val json = request.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            user = jo.get("nutzername").toString()
            uid = jo.get("userid").toString()

            if(user.equals(name)) {
                userid = uid
                gefunden.add("true")
            }
            else{
                gefunden.add("false")
            }
        }

        gf = gefunden.contains("true")

        val request2 = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
        val json2 = request2.jsonArray

        for (ja2 in json2) {
            val jo2 = ja2 as JSONObject
            ln = jo2.get("listename").toString()
            li = jo2.get("listeid").toString()

            if(ln.equals(listeName)) {
                listeid = li
            }
        }//ende for

        val request3 = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/userliste")
        val json3 = request3.jsonArray

        for (ja3 in json3) {
            val jo3 = ja3 as JSONObject
            UID = jo3.get("userid").toString()
            LID = jo3.get("listeid").toString()

            if(userid.equals(UID)) {
                if(listeid.equals(LID)) {
                    anlegen = false
                }
            }
        }//ende for

        var berechtigungs = 0

        if(anlegen && gf){
            val request4 = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/userzuliste?berechtigungs=$berechtigungs&listeid=$listeid&userid=$userid")
            text = 2
            gf = false
        }
        else{
            if(!anlegen){
                text = 1
            }
            if(!gf){
                text = 0
            }
            anlegen = true
        }
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende userhinzufuegen()

    fun listeloeschen(){
        try{
        val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
        val json2 = request.jsonArray

        for (ja2 in json2) {
            val jo2 = ja2 as JSONObject
            ln = jo2.get("listename").toString()
            li = jo2.get("listeid").toString()

            if(ln.equals(listeName)) {
                listeid = li
            }
        }//ende for

        var request2 = khttp.delete("http://digbizmistelbach.at/epo/api/public/index.php/listeloeschen?userid=$angemeldterUser&listeid=$listeid")
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende listeloeschen
}