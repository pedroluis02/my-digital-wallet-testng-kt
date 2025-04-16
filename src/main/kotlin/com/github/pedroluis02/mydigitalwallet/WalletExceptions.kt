package com.github.pedroluis02.mydigitalwallet

object WalletExceptions {

    fun newZeroOrNegativeAmount(amount: Double) = WalletException(
        WalletExceptionType.ZeroOrNegativeAmount,
        "Amount $amount must not be zero or negative."
    )

    fun newMinimumRechargeAmount(amount: Double) = WalletException(
        WalletExceptionType.MinimumRechargeAmount,
        "Minimum amount $amount must not ${WalletConstants.MIN_RECHARGE_AMOUNT}."
    )
}