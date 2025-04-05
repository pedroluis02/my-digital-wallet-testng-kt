package com.github.pedroluis02.mydigitalwallet

import org.testng.Assert
import org.testng.annotations.Test

class WalletControllerTest {

    @Test
    fun testShouldRechargeInitialAmount() {
        val controller = WalletController()

        val amount = 100.0
        controller.recharge(amount)

        Assert.assertEquals(controller.wallet.name, "Default")
        Assert.assertEquals(controller.wallet.balance, amount)
    }

    @Test
    fun testShouldRechargeNextAmount() {
        val initialWallet = Wallet("Initial", 50.0)
        val controller = WalletController(initialWallet)

        val amount = 100.0
        controller.recharge(amount)

        Assert.assertEquals(controller.wallet.name, initialWallet.name)
        Assert.assertEquals(controller.wallet.balance, initialWallet.balance + amount)
    }
}