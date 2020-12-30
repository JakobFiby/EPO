package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object eintragFertigController {
    @JvmStatic

    var en = ""
    var ed = ""
    var eid = ""
    var erledigt = ""
    var fertig = false
    var wk = ""
    var wichtigkeit = ""

    fun connection(aEintrag:String) = try {
        val r = khttp.get("http://localhost/api/public/index.php/eintrag")
        val json = r.jsonArray
        //println(json)

        for (ja in json) {
            val jo = ja as JSONObject
            en = jo.get("eintragname").toString()
            ed = jo.get("erledigt").toString()
            eid = jo.get("eintragid").toString()
            wk = jo.get("wichtigkeit").toString()

            if(en.equals(aEintrag)) {
                wichtigkeit = wk
                if(ed.equals("0")) {
                    erledigt = "1"
                    val r2 = khttp.put("http://localhost/api/public/index.php/updateEintrag?eintragid=$eid&erledigt=$erledigt")
                    fertig = true
                }
                else{
                    erledigt = "0"
                    val r2 = khttp.put("http://localhost/api/public/index.php/updateEintrag?eintragid=$eid&erledigt=$erledigt")
                    fertig = false
                }
            }
        }
    }
    catch(e: SQLException){
        e.printStackTrace()
    }
}