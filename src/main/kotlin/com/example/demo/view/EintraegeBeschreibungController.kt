package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object EintraegeBeschreibungController {
    @JvmStatic

    var beschreibung = ""
    var en:String = ""
    var b:String = ""
    var eintragname = ""

    fun beschreibung(aEintrag:String){
        try {
            eintragname = aEintrag

            val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/eintrag")
            val json = request.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                en = jo.get("eintragname").toString()
                b = jo.get("beschreibung").toString()

                if(en.equals(aEintrag)) {
                    beschreibung = b
                }
            }//ende for
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende beschreibung()

    fun eintragLoeschen(){
        try{
        var request = khttp.delete("http://digbizmistelbach.at/epo/api/public/index.php/eintragloeschen?eintragname=$eintragname")

        EintraegeController.eintraege.clear()
        EintraegeController.connection(EintraegeController.liste)
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende eintragLoeschen
}
