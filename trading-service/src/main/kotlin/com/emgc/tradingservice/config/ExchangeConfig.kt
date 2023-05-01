package com.emgc.tradingservice.config

import exchange.core2.core.ExchangeCore
import exchange.core2.core.IEventsHandler
import exchange.core2.core.IEventsHandler.*
import exchange.core2.core.SimpleEventsProcessor
import exchange.core2.core.common.config.ExchangeConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ExchangeConfig {

    @Bean
    fun exchangeCore(): ExchangeCore {
        return ExchangeCore.builder()
            .resultsConsumer(eventProcessor())
            .exchangeConfiguration(exchangeConfigurations())
            .build()
    }

    private fun eventProcessor(): SimpleEventsProcessor {
        return SimpleEventsProcessor(object : IEventsHandler {
            override fun tradeEvent(tradeEvent: TradeEvent) {
                println("Trade event: $tradeEvent")
            }

            override fun reduceEvent(reduceEvent: ReduceEvent) {
                println("Reduce event: $reduceEvent")
            }

            override fun rejectEvent(rejectEvent: RejectEvent) {
                println("Reject event: $rejectEvent")
            }

            override fun commandResult(commandResult: ApiCommandResult) {
                println("Command result: $commandResult")
            }

            override fun orderBook(orderBook: OrderBook) {
                println("OrderBook event: $orderBook")
            }
        })
    }

    private fun exchangeConfigurations(): ExchangeConfiguration {
        return ExchangeConfiguration.defaultBuilder().build()
    }
}