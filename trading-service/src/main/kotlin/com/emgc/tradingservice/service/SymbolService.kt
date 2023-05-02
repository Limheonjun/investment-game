package com.emgc.tradingservice.service

import com.emgc.tradingservice.enums.Symbol
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.CoreSymbolSpecification
import exchange.core2.core.common.api.binary.BatchAddSymbolsCommand
import org.springframework.stereotype.Service

@Service
class SymbolService(
    private val exchangeCore: ExchangeCore
) {
    fun initSymbol() {
        createSymbol(Symbol.DOLLAR_ETH)
        createSymbol(Symbol.DOLLAR_XBT)
    }
    private fun createSymbol(symbol: Symbol) {
        val symbol = CoreSymbolSpecification.builder()
            .symbolId(symbol.symbolId)
            .type(symbol.symbolType)
            .baseCurrency(symbol.baseCurrency)
            .quoteCurrency(symbol.quoteCurrency)
            .baseScaleK(symbol.baseToQuoteRatio) // 1won 당 설정된 사토시 값 비율 => 1:x
            .quoteScaleK(symbol.minimumQuoteTradingUnit) // quote currency의 거래 단위, 1000 설정 시 0.001단위로 거래 가능
            .takerFee(symbol.takerFee)
            .makerFee(symbol.makerFee)
            .build()

        exchangeCore.api.submitBinaryDataAsync(BatchAddSymbolsCommand(symbol))
    }
}