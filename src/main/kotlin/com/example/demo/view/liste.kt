package com.example.demo.view

import java.util.*

class liste {
    var listename: String? = null
    var faelligkeitsdatum: Date? = null
    var listedatum: Date? = null

    constructor(listename: String, faelligkeitsdatum: Date, listedatum: Date){
        this.listename = listename
        this.faelligkeitsdatum = faelligkeitsdatum
        this.listedatum = listedatum
    }
}