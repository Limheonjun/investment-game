package com.emgc.tradingservice.controller

import com.emgc.tradingservice.service.SymbolService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SymbolController(
    private val symbolService: SymbolService
) {
    @PostMapping("/symbol")
    fun createSymbol() {
        symbolService.createSymbol()
    }
}