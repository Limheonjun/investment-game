package com.emgc.tradingservice.service

import com.emgc.tradingservice.dto.Order
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.api.ApiPlaceOrder
import exchange.core2.core.common.cmd.CommandResultCode
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class OrderService(
    private val exchangeCore: ExchangeCore
) {
    var orderId = 1L
    fun order(order: Order): CompletableFuture<CommandResultCode> {
        val bidOrder = ApiPlaceOrder.builder()
            .uid(order.userId)
            .orderId(orderId++)
            .price(order.price) //price와 reservePrice를 동일하게 설정하지 않으면 에러 발생
            .reservePrice(order.price)
            .size(order.size)
            .action(order.action)
            .orderType(order.orderType)
            .symbol(order.symbol.symbolId)
            .build()

        return exchangeCore.api.submitCommandAsync(bidOrder)
    }
}