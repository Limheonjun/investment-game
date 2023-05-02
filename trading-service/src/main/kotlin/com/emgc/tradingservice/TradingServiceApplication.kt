package com.emgc.tradingservice

import com.emgc.tradingservice.service.DepositService
import com.emgc.tradingservice.service.SymbolService
import com.emgc.tradingservice.service.UserService
import exchange.core2.core.ExchangeCore
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component


@SpringBootApplication
class TradingServiceApplication

fun main(args: Array<String>) {
    runApplication<TradingServiceApplication>(*args)
}

@Component
class ExchangeCoreRunner(
    private val exchangeCore: ExchangeCore,
    private val symbolService: SymbolService,
    private val userService: UserService,
    private val depositService: DepositService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        exchangeCore.startup()
        println("Exchange Core Running . . . . .")

        symbolService.initSymbol()
        println("Initializing Symbols . . .")

        userService.initUser()
        println("Initializing Users . . .")

        depositService.initBalance()
        println("Initializing Balance . . .")
    }
}
