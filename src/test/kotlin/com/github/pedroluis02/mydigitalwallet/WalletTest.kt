package com.github.pedroluis02.mydigitalwallet

import org.testng.Assert
import org.testng.annotations.Test

class WalletTest {

    @Test
    fun testShouldInitializeWithNameAndBalance() {
        val name = "MyWallet"
        val wallet = Wallet(name)

        Assert.assertEquals(wallet.name, name)
        Assert.assertEquals(wallet.balance, 0.0)
        Assert.assertTrue(wallet.transactions.isEmpty())
    }
}