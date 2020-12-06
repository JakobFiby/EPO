package com.example.demo.view

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import khttp.get
import org.json.JSONArray
import org.json.JSONObject
import tornadofx.getProperty
import javax.json.JsonArray

fun main(args: Array<out String>)
{
    //println(get("http://localhost/api/public/index.php/liste").text)

    val r = get("http://localhost/api/public/index.php/liste")

    val string:String = r.toString()

    val json = r.jsonArray

    println(json)

    val gson = Gson()
    /*val arrayTutorialType = object : TypeToken<Array<liste>>() {}.type

    var listen: Array<liste> = gson.fromJson(string, arrayTutorialType)

    println(listen)*/

    //val liste_1: liste = gson.fromJson(json, liste::class.java)


    var output:String = ""


    for(ja in json){
        val jo = ja as JSONObject
        output = jo.get("listename").toString()
        println(output)
    }

    /*for (int i = 0; i < JA.length(); i++){
        JSONObject JO =(JSONObject) JA . get (i);
        single = "Name:" + JO.get("name")
        System.out.println(single);
    }*/
}

