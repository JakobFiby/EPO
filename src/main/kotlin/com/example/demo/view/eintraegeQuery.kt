package com.example.demo.view

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

object eintraegeQuery {
    @JvmStatic

    public var aListenId:Int = 0
    public var eintraege = ArrayList<String>()
    public var liste:String = ""

    fun connection(aListe:String){
        Class.forName("com.mysql.cj.jdbc.Driver")
        try {
            liste = aListe
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck")
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r=s.executeQuery("SELECT listeid FROM liste WHERE listename = '$aListe'")
            r.next()
            aListenId = r.getInt("listeid")

            val s2=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r2=s2.executeQuery("SELECT * FROM eintrag WHERE listeid = $aListenId")
            while(r2.next())
            {
                eintraege.add(r2.getString("eintragname"))
            }

            EintragUebersichtFenster().openWindow()
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }
}