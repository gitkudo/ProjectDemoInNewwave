package com.example.newwavesell.model

import java.lang.NullPointerException

class Pro {
     var name  = ""
     var amount = 0
     var proSize = ""
     var color:Int? = null
     var price = 0
     var upTime = ""

    constructor(
        name: String,
        amount: Int,
        proSize: String,
        color: Int?,
        price: Int,
        upTime: String
    ) {
        this.name = name
        this.amount = amount
        this.proSize = proSize
        this.color = color
        this.price = price
        this.upTime = upTime
    }



}