package com.example.a28mar.model

class Product(var name: String, var price: Float) {
    fun getPriceString(): String{
        return "Prezzon: $price€"
    }
}