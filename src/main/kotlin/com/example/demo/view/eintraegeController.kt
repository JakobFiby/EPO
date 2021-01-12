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
    var wk = ""
    var wichtigkeit = ArrayList<String>()
    var fertig = ""
    var erledigt = ArrayList<String>()

    fun connection(aListe:String) = try {
        liste = aListe

        val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
        val json = r.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            ln = jo.get("listename").toString()
            li = jo.get("listeid").toString()

            if(ln.equals(liste)) {
                listeid = li
            }
        }

        val r2 = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/eintrag")
        val json2 = r2.jsonArray

        var i = 0

        for(ja2 in json2)
        {
            val jo2 = ja2 as JSONObject
            li = jo2.get("listeid").toString()
            en = jo2.get("eintragname").toString()
            wk = jo2.get("wichtigkeit").toString()
            fertig = jo2.get("erledigt").toString()

            if(li.equals(listeid)){
                eintraege.add(en)
                wichtigkeit.add((wk))
                erledigt.add((fertig))
            }

            i++
        }
    }
    catch(e: SQLException){
        e.printStackTrace()
    }
}