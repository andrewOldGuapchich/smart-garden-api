package com.andrew.smart_garden.entity

data class Client(
    val name: String,
    val surname: String,
    val age: Int
)

data class Product (
    val title: String,
    val price: Double,
    val id: String
)