package com.github.pedroluis02.mydigitalwallet

object WalletExceptions {

    fun newZeroOrNegativeAmount(amount: Double) = WalletException(
        WalletExceptionType.ZeroOrNegativeAmount,
        "Amount $amount must not be zero or negative."
    )

    fun newMinimumRechargeAmount(amount: Double) = WalletException(
        WalletExceptionType.MinimumRechargeAmount,
        "Minimum amount $amount must be ${WalletConstants.MIN_RECHARGE_AMOUNT}."
    )

    fun newInsufficientBalance(amount: Double, balance: Double) = WalletException(
        WalletExceptionType.InsufficientBalance,
        "Balance $balance must be equals to amount $amount or greater."
    )
}