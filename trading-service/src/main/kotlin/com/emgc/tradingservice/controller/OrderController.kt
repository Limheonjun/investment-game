package com.emgc.tradingservice.controller

import com.emgc.tradingservice.dto.Order
import com.emgc.tradingservice.service.OrderService
import exchange.core2.core.common.cmd.CommandResultCode
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping("/orders")
    fun bid(@RequestBody order: Order): CompletableFuture<CommandResultCode> {
        return orderService.order(order)
    }
}