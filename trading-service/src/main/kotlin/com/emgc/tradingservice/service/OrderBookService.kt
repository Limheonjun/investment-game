package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.SymbolConstant
import com.emgc.tradingservice.enums.Symbol
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.L2MarketData
import org.springframework.stereotype.Service

@Service
class OrderBookService(
    private val exchangeCore: ExchangeCore
) {
    fun getOrderBook(symbol: Symbol): L2MarketData {
        val requestOrderBookAsync = exchangeCore.api.requestOrderBookAsync(symbol.symbolId, 100)
        return requestOrderBookAsync.get()
    }
}