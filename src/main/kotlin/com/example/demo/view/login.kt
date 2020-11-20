package com.example.demo.view

import java.security.MessageDigest
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import javax.print.DocFlavor


object login {
    @JvmStatic

    public var userId:Int = 0
    public var username:String = ""

    fun test(nutzername: String, passwort: String){
        //println(nutzername)
        //println(passwort)
        var nnB=false
        var pwB=false

        Class.forName("com.mysql.cj.jdbc.Driver")
        try {
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck"
            )
            //println("OK")
            val sUser = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val sPW = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val sUserId = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val user=sUser.executeQuery("SELECT nutzername, userid FROM user ")
            val pw=sPW.executeQuery("SELECT passwort FROM user ")
            val pwHash = MessageDigest.getInstance("MD5")
            //val b = pwHash.digest(pw.getBytes())

            //Login-Überprüfung
            while(user.next()){
                if(user.getString("nutzername").equals(nutzername)){
                    nnB=true
                    userId = user.getInt("userid")
                    username = user.getString("nutzername")
                }
                else{
                    //println("Nutzername ist falsch")
                }
            } //ende while user
            while(pw.next()){
                if(pw.getString("passwort").equals(passwort)){
                    pwB=true
                }
                else{
                    //println("Passwort ist falsch")
                }
            } //ende while pw

            //Login-Überprüfung
            if(pwB==true && nnB==true)
            {
                LoginFenster().close()
                UeberblickFenster().openWindow()
            }
            else{
                println("Nutzername und/oder Passwort sind nicht richtig")
                //LoginFenster().onDock()
            }

        }
        catch (e: SQLException){
            e.printStackTrace()
        }


    }
}