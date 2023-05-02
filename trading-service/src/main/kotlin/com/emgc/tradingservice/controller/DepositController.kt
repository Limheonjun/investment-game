package com.emgc.tradingservice.controller

import com.emgc.tradingservice.enums.Currency
import com.emgc.tradingservice.service.DepositService
import exchange.core2.core.common.api.reports.SingleUserReportResult
import org.springframework.web.bind.annotation.*

@RestController
class DepositController(
    private val depositService: DepositService
) {
    @PostMapping("/deposit")
    fun addBalance(@RequestBody balance: Balance) {
        depositService.addBalance(
            userId = balance.userId,
            amount = balance.amount,
            currency = balance.currencyType
        )
    }

    @GetMapping("/deposit/users/{userId}")
    fun getBalance(@PathVariable userId: Long): SingleUserReportResult {
        val result = depositService.checkBalance(userId).get()
        return result
    }
}

data class Balance(
    val userId: Long,
    val amount: Long,
    val currencyType: Currency
)