package com.example.demo.view

import com.example.demo.view.login.sha256
import javafx.scene.control.Label
import tornadofx.*
import java.awt.Image
import java.io.InputStream
import java.security.MessageDigest
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import javax.print.DocFlavor
import javax.xml.bind.DatatypeConverter
import java.math.BigInteger

object register {

    var userph: Label by singleAssign()

    fun anmelden(nutzernameR:String, vorname:String, nachname:String, email:String, passwortR:String) {
        //println(nutzernameR+vorname+nachname+email+passwortR)

        Class.forName("com.mysql.cj.jdbc.Driver")
        try {
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "digbizm_7", "2021##Epo5ck"
            )
            //println("OK")
            val sUser = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val user=sUser.executeQuery("SELECT * FROM user")

            //passwort hashen
            val pwhash: String = passwortR.sha256()

            //Vorname und Nachname müssen groß geschrieben sein

            user.next()
            user.moveToInsertRow()
            user.updateString("nutzername", nutzernameR)
            user.updateString("passwort", pwhash)
            user.updateBoolean("mitteilungen", true)
            user.updateBoolean("abmelden", false)
            user.updateString("vorname", vorname)
            user.updateString("nachname", nachname)
            user.updateString("email", email)
            user.updateString("farbschemaid", "1")
            user.updateString("profilbildid", "1")
            user.insertRow()

            //Registrieren erfolgreich


        }
        catch(e:SQLException){
            e.printStackTrace()
        }
    }

    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

}
