package com.emgc.tradingservice.dto

import exchange.core2.core.common.SymbolType

data class Symbol(
    val symbolId: Int, // 종목 ID(btc/eth, krw/btc 등과 같은 관계를 정의하는 ID
    val symbolType: SymbolType, // 현물, 선물, 옵션
    val baseCurrency: Int, // 기준화폐
    val quoteCurrency: Int, // 상대화폐
    val baseToQuoteRatio: Long, // 기준화폐 대 상대화폐 비율(1:x)
    val minimumQuoteTradingUnit: Int, // 최소 거래 가능 단위(1000설정 시 0.001 단위로 거래 가능)
    val takerFee: Long, // taker(시장가 주문하는 사람들) 수수료
    val makerFee: Long // maker(지정가 주문하는 사람들) 수수료
)