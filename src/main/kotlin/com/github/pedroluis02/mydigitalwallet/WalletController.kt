package com.github.pedroluis02.mydigitalwallet

class WalletController(initWallet: Wallet? = null) {

    private var _wallet: Wallet = initWallet ?: Wallet("Default")
    val wallet: Wallet
        get() = _wallet

    fun recharge(amount: Double) {
        val newBalance = _wallet.balance + amount
        val newTransaction = Transaction(amount, type = TransactionType.Recharge.name)

        val transactions = _wallet.transactions.toMutableList()
        transactions.add(newTransaction)

        _wallet = _wallet.copy(balance = newBalance, transactions = transactions)
    }
}