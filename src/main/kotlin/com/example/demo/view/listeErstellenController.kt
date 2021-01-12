package com.example.demo.view

import org.json.JSONObject
import java.time.LocalDate

object listeErstellenController {
    @JvmStatic
    var gefunden = ArrayList<String>()
    var ln:String = ""
    var li:String = ""
    var listeid:Int = 0
    var berechtigungs = 0
    var erstellt = false

    fun listehinzufügen(listename:String, userid:Int, fdatum: LocalDate, ldatum: LocalDate){

        gefunden.clear()

        val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
        val json = r.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            ln = jo.get("listename").toString()

            if(ln.equals(listename)) {
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
            val request = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/listeneu?listename=$listename&listedatum=$ldatum&faelligkeitsdatum=$fdatum")

            val r2 = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/liste")
            val json2 = r2.jsonArray

            for (ja2 in json2) {
                val jo2 = ja2 as JSONObject
                ln = jo2.get("listename").toString()
                li = jo2.get("listeid").toString()

                if(ln.equals(listename)) {
                    listeid = li.toInt()
                    println(listeid)
                }
            }

            val request2 = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/userzuliste?berechtigungs=$berechtigungs&listeid=$listeid&userid=$userid")
        }
    }
}