package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.CurrencyConstant
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.api.ApiAdjustUserBalance
import org.springframework.stereotype.Service

@Service
class DepositService(
    private val exchangeCore: ExchangeCore
) {
    var transactionId = 1L
    fun addBalanceWon(userId: Long, amount: Long) {
        val userBalance = ApiAdjustUserBalance.builder()
            .uid(userId)
            .currency(CurrencyConstant.WON)
            .amount(amount)
            .transactionId(transactionId++)
            .build()

        exchangeCore.api.submitCommandAsync(userBalance)
    }

    fun addBalanceLimvestment(userId: Long, amount: Long) {
        val userBalance = ApiAdjustUserBalance.builder()
            .uid(userId)
            .currency(CurrencyConstant.LIMVESTMENT)
            .amount(amount)
            .transactionId(transactionId++)
            .build()

        exchangeCore.api.submitCommandAsync(userBalance)
    }
}