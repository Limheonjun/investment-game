package com.emgc.tradingservice.controller

import com.emgc.tradingservice.service.OrderBookService
import exchange.core2.core.common.L2MarketData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderBookController(
    private val orderBookService: OrderBookService
) {
    @GetMapping("/orderbook")
    fun getOrderBook(): L2MarketData {
        return orderBookService.getOrderBook()
    }
}