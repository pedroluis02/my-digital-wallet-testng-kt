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

    @Test(expectedExceptions = [WalletException::class])
    fun testShouldNotRechargeZeroAmount() {
        val controller = WalletController()

        controller.recharge(0.0)
    }

    @Test(expectedExceptions = [WalletException::class])
    fun testShouldNotRechargeMinimumAmount() {
        val controller = WalletController()

        controller.recharge(2.0)
    }

    @Test(expectedExceptions = [WalletException::class])
    fun testShouldNotRechargeNegativeAmount() {
        val controller = WalletController()

        controller.recharge(-1.0)
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

    @Test
    fun testShouldPayAmountFromBalance() {
        val controller = WalletController()
        controller.recharge(100.0)

        controller.pay(60.0)

        val wallet = controller.wallet
        Assert.assertEquals(wallet.balance, 40.0)
        Assert.assertEquals(wallet.transactions.size, 2)
    }
}