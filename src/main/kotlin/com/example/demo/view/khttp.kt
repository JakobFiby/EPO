package com.example.demo.view

import khttp.get
import org.json.JSONArray
import java.util.*
import javax.json.Json
import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main(args: Array<out String>)
{
    //println(get("http://localhost/api/public/index.php/liste").text)

    val r = get("http://localhost/api/public/index.php/liste")

    val json = r.jsonArray

    println(json)

    val gson = Gson()
    val arrayTutorialType = object : TypeToken<Array<liste>>() {}.type

    //var listen: Array<liste> = gson.fromJson(json, arrayTutorialType)

    //val liste_1: liste = gson.fromJson(json, liste::class.java)
}

