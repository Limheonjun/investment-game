package com.emgc.tradingservice

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
    private val exchangeCore: ExchangeCore
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        exchangeCore.startup()
        println("Exchange Core Running . . . . .")
    }
}
