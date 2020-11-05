package com.example.demo.app

import com.example.demo.view.EintragErstellenFenster
import com.example.demo.view.ListeErstellenFenster
import com.example.demo.view.LoginFenster
import com.example.demo.view.UeberblickFenster
import tornadofx.App

//class MyApp: App(LoginFenster::class, Styles::class)

class MyApp: App(UeberblickFenster::class, Styles::class)