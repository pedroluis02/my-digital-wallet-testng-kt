package com.github.pedroluis02.mydigitalwallet

object WalletExceptions {

    fun newZeroOrNegativeAmount(amount: Double) = WalletException(
        WalletExceptionType.ZeroOrNegativeAmount,
        "Amount $amount must not be zero or negative."
    )
}