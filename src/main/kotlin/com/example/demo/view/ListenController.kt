package com.example.demo.view

import java.sql.SQLException
import org.json.JSONObject

object ListenController{
    @JvmStatic

    var userid:Int = LoginController.userId
    var ui: String = ""
    var li: String = ""
    var fd: String = ""
    var ln: String = ""
    var listenid = ArrayList<String>()
    var listenname = ArrayList<String>()
    var listenFaelligkeitsDatum = ArrayList<String>()

    fun connection(userid: Int){
        try {
            ui = ""
            li = ""
            fd = ""
            ln = ""
            listenid.clear()
            listenname.clear()
            listenFaelligkeitsDatum.clear()

            val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/userliste")
            val json = r.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                ui = jo.get("userid").toString()
                li = jo.get("listeid").toString()

                if(ui.equals(userid.toString())) {
                    listenid.add(li)
                }//ende if
            }//ende for

            val r2 = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
            val json2 = r2.jsonArray

            var i = 0

            for(ja2 in json2) {
                val jo2 = ja2 as JSONObject
                li = jo2.get("listeid").toString()
                fd = jo2.get("faelligkeitsdatum").toString()
                ln = jo2.get("listename").toString()

                for(listid in listenid) {
                    if (li.equals(listid)) {
                        listenname.add((ln))
                        listenFaelligkeitsDatum.add(fd)
                    }//ende if
                }//ende for
                i++
            }//ende for
        }//ende try
        catch(e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende connection()

}