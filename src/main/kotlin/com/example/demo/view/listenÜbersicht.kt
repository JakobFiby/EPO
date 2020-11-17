package com.example.demo.view

object listenÜbersicht
{
    var listeid = ArrayList<Int>()
    var listename = ArrayList<String>()

    fun data()
    {
        listenQuery.connection()
        listeid = listenQuery.listenid
        for(li in listeid)
        {
            println(li)
        }

        listename = listenQuery.listenname
        for(la in listename)
        {
            println(la)
        }

        UeberblickFenster().lid = listeid
        UeberblickFenster().lna = listename
    }
}
