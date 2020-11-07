package com.example.demo.view

import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.*

object Test {

    @JvmStatic
    fun connection(){
        Class.forName("com.microsoft.sqlserver")
        try{
            // @Kathi --> ich hab mir so einen jdbc Driver runtergeladen, aba keinen Plan, war das jz doch nd funkt
            //i bin wirklich am verzweifeln

            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    //hab mich auch nochmal über DB-URLS informiert und unsere sollte stimmmen
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