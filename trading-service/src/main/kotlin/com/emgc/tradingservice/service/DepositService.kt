package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.CurrencyConstant
import com.emgc.tradingservice.enums.Currency
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.api.ApiAdjustUserBalance
import exchange.core2.core.common.api.reports.SingleUserReportQuery
import exchange.core2.core.common.api.reports.SingleUserReportResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class DepositService(
    private val exchangeCore: ExchangeCore
) {
    var transactionId = 1L
    var transferId = 1

    fun initBalance() {
        addBalance(userId = 1, amount = 100_000, currency = Currency.DOLLAR)
        addBalance(userId = 1, amount = 100_000, currency = Currency.XBT)
        addBalance(userId = 2, amount = 500_000, currency = Currency.DOLLAR)
        addBalance(userId = 2, amount = 200_000, currency = Currency.XBT)
    }
    fun addBalance(
        userId: Long,
        amount: Long,
        currency: Currency
    ) {
        val userBalance = ApiAdjustUserBalance.builder()
            .uid(userId)
            .currency(currency.id)
            .amount(amount)
            .transactionId(transactionId++)
            .build()

        exchangeCore.api.submitCommandAsync(userBalance)
    }

    fun checkBalance(userId: Long): CompletableFuture<SingleUserReportResult> {
        return exchangeCore.api.processReport(SingleUserReportQuery(userId), 0);
    }
}