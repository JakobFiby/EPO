package com.example.demo.view

import java.sql.DriverManager

class Database {
    fun main(args: Array<String>) {
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val con = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs", "digbizm_7", "2021##Epo5ck")

            val stmt = con.createStatement()
            val rs = stmt.executeQuery("select * from emp")
            while (rs.next()) println(rs.getInt(1).toString() + "  " + rs.getString(2) + "  " + rs.getString(3))
            con.close()
        } catch (e: Exception) {
            println(e)
        }
    }
}

//ich hab hier eine Vorlage einer Database Class eingefügt
//hab die Daten hinzugefügt, aber was heißt bei der SQL-Query "emp"? versteh ich nicht lul
