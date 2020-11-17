package com.example.demo.view

import javafx.beans.property.SimpleObjectProperty
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import tornadofx.getValue
import tornadofx.setValue

object listenQuery {
    @JvmStatic

    var userid:Int = login.userId
    public var listenid = ArrayList<Int>()
    public var listenname = ArrayList<String>()
    var li:Int = 0

    fun connection(){
        Class.forName("com.mysql.cj.jdbc.Driver")
        try {
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck")
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r=s.executeQuery("SELECT * FROM userliste WHERE userid = $userid")
            while(r.next())
            {
                listenid.add(r.getInt("listeid"))
            }

            //println(listenid[1].toString())

            val s2=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            for(li in listenid) {
                val r2 = s2.executeQuery("SELECT * FROM liste WHERE listeid = $li")
                r2.next()
                listenname.add(r2.getString("listename"))
                //println(r2.getString("listename"))
            }

        }
        catch(e: SQLException){
            e.printStackTrace()
        }
    }
}