package com.github.pedroluis02.mydigitalwallet

data class Wallet(
    val name: String,
    val balance: Double = 0.0,
    val transactions: List<Transaction> = emptyList()
)