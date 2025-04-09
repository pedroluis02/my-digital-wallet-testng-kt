package com.github.pedroluis02.mydigitalwallet

import org.testng.Assert
import org.testng.annotations.Test

class WalletControllerTest {

    @Test
    fun testShouldRechargeInitialAmount() {
        val controller = WalletController()

        val amount = 100.0
        controller.recharge(amount)

        val wallet = controller.wallet
        Assert.assertEquals(wallet.name, "Default")
        Assert.assertEquals(wallet.balance, amount)
        Assert.assertEquals(wallet.transactions.size, 1)
    }

    @Test
    fun testShouldRechargeNextAmount() {
        val initialWallet = Wallet("Initial", 50.0)
        val controller = WalletController(initialWallet)

        val amount = 100.0
        controller.recharge(amount)

        val wallet = controller.wallet
        Assert.assertEquals(wallet.name, initialWallet.name)
        Assert.assertEquals(wallet.balance, initialWallet.balance + amount)
        Assert.assertEquals(wallet.transactions.size, 2)
    }

    @Test
    fun testShouldHaveInitialWalletWithAmountAndTransactions() {
        val initialWallet = Wallet("Initial", 50.0, listOf(Transaction(50.0, TransactionType.Recharge.name)))
        val controller = WalletController(initialWallet)

        val wallet = controller.wallet
        Assert.assertEquals(wallet.name, initialWallet.name)
        Assert.assertEquals(wallet.balance, initialWallet.balance)
        Assert.assertEquals(wallet.transactions.size, 1)
    }
}