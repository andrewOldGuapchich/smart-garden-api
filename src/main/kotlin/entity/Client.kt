package com.andrew.smart_garden.entity

data class Client(
    private val name: String,
    private val surname: String,
    private val age: Int
)

data class Product (
    private val title: String
)