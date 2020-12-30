package com.example.demo.view

import org.json.JSONObject

object eintragErstellenController {
    @JvmStatic
    var gefunden = ArrayList<String>()
    var en:String = ""
    var li:String = ""
    var erstellt = false

    fun eintraghinzufügen(name:String, beschreibung:String, erledigt:Int, wichtigkeit:String, listeid:Int){

        gefunden.clear()

        val r = khttp.get("http://localhost/api/public/index.php/eintrag")
        val json = r.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            en = jo.get("eintragname").toString()

            if(en.equals(name)) {
                gefunden.add("true")
            }
            else{
                gefunden.add("false")
            }
        }

        if(gefunden.contains("true")){
            erstellt = false
        }
        else{
            erstellt = true

            val request = khttp.post("http://localhost/api/public/index.php/eintragneu?eintragname=$name&beschreibung=$beschreibung&erledigt=$erledigt&wichtigkeit=$wichtigkeit&listeid=$listeid")
        }

        eintraegeController.eintraege.clear()
        eintraegeController.connection(eintraegeController.liste)
    }
}