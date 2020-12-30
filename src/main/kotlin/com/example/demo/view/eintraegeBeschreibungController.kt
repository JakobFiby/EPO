package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object eintraegeBeschreibungController {
    @JvmStatic

    var beschreibung = ""
    var en:String = ""
    var b:String = ""
    var eintragname = ""

    fun beschreibung(aEintrag:String){
        try {
            eintragname = aEintrag

            val r = khttp.get("http://localhost/api/public/index.php/eintrag")
            val json = r.jsonArray
            //println(json)

            for (ja in json) {
                val jo = ja as JSONObject
                en = jo.get("eintragname").toString()
                b = jo.get("beschreibung").toString()

                if(en.equals(aEintrag)) {
                    beschreibung = b
                }
            }
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }

    fun eintragLoeschen(){

        var r = khttp.delete("http://localhost/api/public/index.php/eintragloeschen?eintragname=$eintragname")

        eintraegeController.eintraege.clear()
        eintraegeController.connection(eintraegeController.liste)
    }
}
