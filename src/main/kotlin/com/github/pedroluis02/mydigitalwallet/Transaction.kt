package com.github.pedroluis02.mydigitalwallet

import java.util.Date

data class Transaction(
    val amount: Double,
    val description: String = "",
    val type: String = "",
    val createdAt: Date = Date()
)
