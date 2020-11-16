package com.example.demo.view

object login {
    @JvmStatic
    fun test(){
        Test.connection()
        var va = Test.variable
        var nn = LoginFenster().nutzerna
        //why null bro
        println(nn + " 123")
        println(va)

        //if(va.equals(nn))
        //{
            UeberblickFenster().openWindow()
            listenQuery.connection()
        //}
    }
}