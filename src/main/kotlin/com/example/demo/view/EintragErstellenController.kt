package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object EintragErstellenController {
    @JvmStatic
    var gefunden = ArrayList<String>()
    var en:String = ""
    var li:String = ""
    var erstellt = false

    fun eintraghinzufügen(name:String, beschreibung:String, erledigt:Int, wichtigkeit:String, listeid:Int){
        try{
        gefunden.clear()

        val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/eintrag")
        val json = request.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            en = jo.get("eintragname").toString()

            if(en.equals(name)) {
                gefunden.add("true")
            }
            else{
                gefunden.add("false")
            }
        }//ende for

        if(gefunden.contains("true")){
            erstellt = false
        }
        else{
            erstellt = true

            val request2 = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/eintragneu?eintragname=$name&beschreibung=$beschreibung&erledigt=$erledigt&wichtigkeit=$wichtigkeit&listeid=$listeid")
        }

        EintraegeController.eintraege.clear()
        EintraegeController.connection(EintraegeController.liste)
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende eintraghinzufuegen()
}