package com.example.demo.view

import org.json.JSONObject
import java.sql.SQLException

object EintragFertigController {
    @JvmStatic

    var en = ""
    var ed = ""
    var eid = ""
    var erledigt = ""
    var fertig = false
    var wk = ""
    var wichtigkeit = ""

    fun connection(aEintrag:String) = try {
        val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/eintrag")
        val json = request.jsonArray

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
                    val request2 = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateEintrag?eintragid=$eid&erledigt=$erledigt")
                    fertig = true
                }//ende if 1
                else{
                    erledigt = "0"
                    val request2 = khttp.put("http://digbizmistelbach.at/epo/api/public/index.php/updateEintrag?eintragid=$eid&erledigt=$erledigt")
                    fertig = false
                }//ende if 2
            }//ende if gesamt
        }//ende for
    }//ende try & connection()
    catch(e: SQLException){
        e.printStackTrace()
    }//ende catch
}