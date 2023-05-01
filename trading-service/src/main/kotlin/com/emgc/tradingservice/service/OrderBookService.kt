package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.SymbolConstant
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.L2MarketData
import org.springframework.stereotype.Service

@Service
class OrderBookService(
    private val exchangeCore: ExchangeCore
) {
    fun getOrderBook(): L2MarketData {
        val requestOrderBookAsync = exchangeCore.api.requestOrderBookAsync(SymbolConstant.WON_LIMVESTMENT, 10)
        return requestOrderBookAsync.get()
    }
}