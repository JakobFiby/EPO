package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object eintraegeBeschreibungController {
    @JvmStatic

    var beschreibung = ""
    var en:String = ""
    var b:String = ""

    fun connection(aEintrag:String){
        try {
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

            /*val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck")
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r=s.executeQuery("SELECT beschreibung FROM eintrag WHERE eintragname = '$aEintrag'")
            r.next()
            beschreibung = r.getString("beschreibung"*/

            EintraegeBeschreibung().openWindow()
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }
}
