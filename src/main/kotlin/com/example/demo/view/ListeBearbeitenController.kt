package com.example.demo.view

import org.json.JSONObject

object ListeBearbeitenController {
    @JvmStatic

    var userid:String = ""
    var user:String = ""
    var uid:String = ""
    var gefunden = ArrayList<String>()
    var listeName:String = ""
    var ln = ""
    var li = ""
    var listeid = ""
    var UID = ""
    var LID = ""
    var anlegen:Boolean = true
    var text:Int = 0
    var gf = false

    fun getName(aListe:String){
        listeName = aListe
        //println(listeName)
    }

    fun userhinzufügen(name:String){
        //println(name)
        gefunden.clear()
        
        val r = khttp.get("http://localhost/api/public/index.php/benutzer")
        val json = r.jsonArray

        for (ja in json) {
            val jo = ja as JSONObject
            user = jo.get("nutzername").toString()
            uid = jo.get("userid").toString()

            if(user.equals(name)) {
                userid = uid
                //println(userid)
                gefunden.add("true")
            }
            else{
                gefunden.add("false")
            }
        }

        if(gefunden.contains("true")) { gf = true}
        else{ gf = false }

        //println(listeName)

        val r2 = khttp.get("http://localhost/api/public/index.php/liste")
        val json2 = r2.jsonArray

        for (ja2 in json2) {
            val jo2 = ja2 as JSONObject
            ln = jo2.get("listename").toString()
            li = jo2.get("listeid").toString()

            if(ln.equals(listeName)) {
                listeid = li
                //println(listeid)
            }
        }

        val r3 = khttp.get("http://localhost/api/public/index.php/userliste")
        val json3 = r3.jsonArray
        //println(json3)

        for (ja3 in json3) {
            val jo3 = ja3 as JSONObject
            UID = jo3.get("userid").toString()
            LID = jo3.get("listeid").toString()

            if(userid.equals(UID)) {
                if(listeid.equals(LID)) {
                    anlegen = false
                }
            }
        }

        var berechtigungs = 0

        if(anlegen && gf){
            val request = khttp.post("http://localhost/api/public/index.php/userzuliste?berechtigungs=$berechtigungs&listeid=$listeid&userid=$userid")
            text = 2
            gf = false
        }
        else{
            if(!anlegen){
                text = 1
            }
            if(!gf){
                text = 0
            }
            anlegen = true
        }
    }
}