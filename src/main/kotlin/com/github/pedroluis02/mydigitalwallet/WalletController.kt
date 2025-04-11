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
                    updateBalance(it.balance)
                }
            }
        }
    }

    fun recharge(amount: Double) {
        if (amount <= 0) {
            throw WalletException(
                WalletExceptionType.ZeroOrNegativeAmount, "Amount $amount must not be zero or " +
                        "negative."
            )
        }

        updateBalance(amount)

        val newTransaction = Transaction(amount, type = TransactionType.Recharge.name)
        _transactions.add(newTransaction)
    }

    private fun updateBalance(amount: Double) {
        _wallet = _wallet.copy(balance = _wallet.balance + amount)
    }
}