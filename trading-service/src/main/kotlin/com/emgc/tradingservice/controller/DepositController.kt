package com.emgc.tradingservice.controller

import com.emgc.tradingservice.service.DepositService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DepositController(
    private val depositService: DepositService
) {
    @PostMapping("/deposit")
    fun addBalance(@RequestBody balance: Balance) {
        if(balance.currencyType == "won") {
            depositService.addBalanceWon(
                userId = balance.userId,
                amount = balance.amount
            )
        } else {
            depositService.addBalanceLimvestment(
                userId = balance.userId,
                amount = balance.amount
            )
        }

    }
}

data class Balance(
    val userId: Long,
    val amount: Long,
    val currencyType: String
)