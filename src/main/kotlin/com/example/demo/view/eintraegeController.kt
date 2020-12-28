package com.example.demo.view

import org.json.JSONObject
import tornadofx.*
import java.sql.SQLException

object eintraegeController {
    @JvmStatic

    var aListenId:Int = 0
    var eintraege = ArrayList<String>()
    var liste:String = ""
    var ln:String = ""
    var li:String = ""
    var en:String = ""
    var listeid:String = ""

    fun connection(aListe:String) = try {
        liste = aListe
        //println(liste)

        val r = khttp.get("http://localhost/api/public/index.php/liste")
        val json = r.jsonArray
        //println(json)

        for (ja in json) {
            val jo = ja as JSONObject
            ln = jo.get("listename").toString()
            li = jo.get("listeid").toString()

            if(ln.equals(liste)) {
                listeid = li
                //println(listeid)
            }
        }

        val r2 = khttp.get("http://localhost/api/public/index.php/eintrag")
        val json2 = r2.jsonArray
        //println(json2)

        var i = 0

        for(ja2 in json2)
        {
            val jo2 = ja2 as JSONObject
            li = jo2.get("listeid").toString()
            en = jo2.get("eintragname").toString()

            if(li.equals(listeid)){
                eintraege.add(en)
            }

            i++
        }
        //println(eintraege)
        //println(liste)

        /*EintragUebersichtFenster().onRefresh()
        EintragUebersichtFenster().root.reloadStylesheets()*/

        //EintragUebersichtFenster().form().button("Hallo")
    }
    catch(e: SQLException){
        e.printStackTrace()
    }
}