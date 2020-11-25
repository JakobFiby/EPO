package com.example.demo.view

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

object eintraegeBeschreibungQuery {
    @JvmStatic

    public var beschreibung = ""

    fun connection(aEintrag:String){
        Class.forName("com.mysql.cj.jdbc.Driver")
        try {
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck")
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r=s.executeQuery("SELECT beschreibung FROM eintrag WHERE eintragname = '$aEintrag'")
            r.next()
            beschreibung = r.getString("beschreibung")

            EintraegeBeschreibung().openWindow()
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }
}
