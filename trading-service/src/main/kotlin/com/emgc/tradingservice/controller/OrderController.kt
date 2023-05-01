package com.emgc.tradingservice.controller

import com.emgc.tradingservice.service.OrderService
import exchange.core2.core.common.cmd.CommandResultCode
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping("/bid")
    fun bid(): CompletableFuture<CommandResultCode> {
        return orderService.bid()
    }

    @PostMapping("/ask")
    fun ask() {
        orderService.ask()
    }
}