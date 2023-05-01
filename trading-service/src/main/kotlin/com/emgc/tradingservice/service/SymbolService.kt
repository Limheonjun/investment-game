package com.emgc.tradingservice.service

import com.emgc.tradingservice.constant.CurrencyConstant
import com.emgc.tradingservice.constant.SymbolConstant
import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.CoreSymbolSpecification
import exchange.core2.core.common.SymbolType
import exchange.core2.core.common.api.binary.BatchAddSymbolsCommand
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SymbolService(
    private val exchangeCore: ExchangeCore
) {
    fun createSymbol() {
        val symbol = CoreSymbolSpecification.builder()
            .symbolId(SymbolConstant.WON_LIMVESTMENT)
            .type(SymbolType.CURRENCY_EXCHANGE_PAIR)
            .baseCurrency(CurrencyConstant.WON)
            .quoteCurrency(CurrencyConstant.LIMVESTMENT)
            .baseScaleK(CurrencyConstant.WON_TO_BTC_RATIO) // 1won 당 설정된 사토시 값 비율 => 1:x
            .quoteScaleK(CurrencyConstant.LIMVESTMENT_PRICE_STEP) // quote currency의 거래 단위, 1000 설정 시 0.001단위로 거래 가능
            .takerFee(SymbolConstant.WON_LIMVESTMENT_TAKER_FEE)
            .makerFee(SymbolConstant.WON_LIMVESTMENT_MAKER_FEE)
            .build()

        exchangeCore.api.submitBinaryDataAsync(BatchAddSymbolsCommand(symbol))
    }
}