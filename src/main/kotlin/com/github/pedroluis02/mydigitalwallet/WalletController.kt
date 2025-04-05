package com.github.pedroluis02.mydigitalwallet

class WalletController(initWallet: Wallet? = null) {

    private var _wallet: Wallet = initWallet ?: Wallet("Default")
    val wallet: Wallet
        get() = _wallet

    fun recharge(amount: Double) {
        _wallet = _wallet.copy(balance = _wallet.balance + amount)
    }
}