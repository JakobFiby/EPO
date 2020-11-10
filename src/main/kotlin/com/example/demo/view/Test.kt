package com.example.demo.view

import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.*

object Test {

    @JvmStatic
    fun connection(){
        Class.forName("com.mysql.cj.jdbc.Driver")
        try{
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck"
            )
            println("OK")
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r=s.executeQuery("SELECT * FROM user")
        }
        catch(e:SQLException){
            e.printStackTrace()
        }
    }
}