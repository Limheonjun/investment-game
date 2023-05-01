package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.SymbolConstant
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.OrderAction
import exchange.core2.core.common.OrderType
import exchange.core2.core.common.api.ApiPlaceOrder
import exchange.core2.core.common.cmd.CommandResultCode
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class OrderService(
    private val exchangeCore: ExchangeCore
) {
    var orderId = 1L
    fun bid(): CompletableFuture<CommandResultCode> {
        // first user places Good-till-Cancel Bid order
        // he assumes BTCLTC exchange rate 154 LTC for 1 BTC
        // bid price for 1 lot (0.01BTC) is 1.54 LTC => 1_5400_0000 litoshi => 10K * 15_400 (in price steps)
        val bidOrder = ApiPlaceOrder.builder()
            .uid(301L)
            .orderId(orderId++)
            .price(100L)
            .reservePrice(200L) // can move bid order up to the 1.56 LTC, without replacing it
            .size(12L) // order size is 12 lots
            .action(OrderAction.BID)
            .orderType(OrderType.GTC) // Good-till-Cancel
            .symbol(SymbolConstant.WON_LIMVESTMENT)
            .build()

        return exchangeCore.api.submitCommandAsync(bidOrder)
    }

    fun ask() {
        val askOrder = ApiPlaceOrder.builder()
            .uid(302L)
            .orderId(orderId++)
            .price(15_250L)
            .size(10L) // order size is 10 lots
            .action(OrderAction.ASK)
            .orderType(OrderType.IOC) // Immediate-or-Cancel
            .symbol(SymbolConstant.WON_LIMVESTMENT)
            .build()

        exchangeCore.api.submitCommandAsync(askOrder)
    }
}