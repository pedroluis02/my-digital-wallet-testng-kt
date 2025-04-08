package com.github.pedroluis02.mydigitalwallet

class WalletController(initWallet: Wallet? = null) {

    private var _wallet: Wallet = initWallet ?: Wallet("Default")
    private var _transactions: MutableList<Transaction> = mutableListOf()

    val wallet: Wallet
        get() = _wallet.copy(transactions = _transactions)

    fun recharge(amount: Double) {
        val newBalance = _wallet.balance + amount
        val newTransaction = Transaction(amount, type = TransactionType.Recharge.name)

        _transactions.add(newTransaction)
        _wallet = _wallet.copy(balance = newBalance)
    }
}