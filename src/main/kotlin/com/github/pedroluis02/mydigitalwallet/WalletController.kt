package com.github.pedroluis02.mydigitalwallet

class WalletController(initWallet: Wallet? = null) {

    private var _wallet: Wallet = Wallet("Default")
    private var _transactions: MutableList<Transaction> = mutableListOf()

    val wallet: Wallet
        get() = _wallet.copy(transactions = _transactions)

    init {
        initWallet?.let {
            _wallet = _wallet.copy(name = it.name)
            if (it.transactions.isNotEmpty()) {
                _transactions.addAll(it.transactions)
            }

            if (it.balance > 0) {
                if (it.transactions.isEmpty()) {
                    recharge(it.balance)
                } else {
                    _wallet = _wallet.copy(balance = it.balance)
                }
            }
        }
    }

    fun recharge(amount: Double) {
        val newBalance = _wallet.balance + amount
        val newTransaction = Transaction(amount, type = TransactionType.Recharge.name)

        _wallet = _wallet.copy(balance = newBalance)
        _transactions.add(newTransaction)
    }
}