package com.example.demo.view

import java.sql.SQLException
import org.json.JSONObject

object listenController{
    @JvmStatic

    var userid:Int = loginController.userId
    var ui: String = ""
    var li: String = ""
    var fd: String = ""
    var ln: String = ""
    var listenid = ArrayList<String>()
    var listenname = ArrayList<String>()
    var listenFaelligkeitsDatum = ArrayList<String>()

    fun connection(userid: Int){
        try {
            val r = khttp.get("http://localhost/api/public/index.php/listeid")
            val json = r.jsonArray
            //println(json)

            for (ja in json) {
                val jo = ja as JSONObject
                ui = jo.get("userid").toString()
                li = jo.get("listeid").toString()

                if(ui.equals(userid.toString())) {
                    listenid.add(li)
                    //println(li)
                }
            }

            val r2 = khttp.get("http://localhost/api/public/index.php/listename")
            val json2 = r2.jsonArray
            //println(json2)

            var i = 0

            for(ja2 in json2)
            {
                val jo2 = ja2 as JSONObject
                li = jo2.get("listeid").toString()
                fd = jo2.get("faelligkeitsdatum").toString()
                ln = jo2.get("listename").toString()

                for(listid in listenid) {
                    if (li.equals(listid)) {
                        listenname.add((ln))
                        listenFaelligkeitsDatum.add(fd)
                    }
                }

                i++
            }
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }
}