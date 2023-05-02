package com.emgc.tradingservice.controller

import com.emgc.tradingservice.enums.Symbol
import com.emgc.tradingservice.service.OrderBookService
import exchange.core2.core.common.L2MarketData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderBookController(
    private val orderBookService: OrderBookService
) {
    @GetMapping("/orderbook/{symbolName}")
    fun getOrderBook(@PathVariable symbolName: String): L2MarketData {
        val symbol = Symbol.from(symbolName)!!
        return orderBookService.getOrderBook(symbol)
    }
}