package com.github.pedroluis02.mydigitalwallet

data class WalletException(
    val type: WalletExceptionType = WalletExceptionType.Default,
    override val message: String = ""
) : RuntimeException(message)
