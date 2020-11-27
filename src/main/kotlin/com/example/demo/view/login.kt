package com.example.demo.view

import tornadofx.*
import java.security.MessageDigest
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import javax.print.DocFlavor
import javax.xml.bind.DatatypeConverter
import java.math.BigInteger
import com.example.demo.view.LoginFenster
import com.example.demo.view.UeberblickFenster

object login {
    @JvmStatic

    public var userId:Int = 0
    public var username:String = ""
    public var nnB:Boolean=false
    public var pwB:Boolean=false

    fun ueberpruefen(nutzername: String, passwort: String){
        //println(nutzername)
        //println(passwort)

        var funktioniert=false

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

            var pwhash = passwort.sha256()
            //println("computed sha256 value is $pwhash")
            if(pwhash.length==63){
                pwhash= "0"+pwhash
                println("computed sha256 value is $pwhash")
            }
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
                if(pw.getString("passwort").equals(pwhash)){
                    pwB=true
                }
                else{
                    //println("Passwort ist falsch")
                }
            } //ende while pw

            //Login-Überprüfung
            //if(pwB==true && nnB==true) {
                //LoginFenster().close()
                //UeberblickFenster().openWindow()

                //LoginFenster().replaceWith(UeberblickFenster::class, sizeToScene = true, centerOnScreen = true)
                //println("funktioniert ned")

            //}
            //else{
                //println("Nutzername und/oder Passwort sind nicht richtig")
                //LoginFenster().onDock()
            //}

        }
        catch (e: SQLException){
            e.printStackTrace()
        }


    }

    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

}