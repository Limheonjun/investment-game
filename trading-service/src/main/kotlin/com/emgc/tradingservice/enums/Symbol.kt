package com.emgc.tradingservice.enums

import exchange.core2.core.common.SymbolType

enum class Symbol(
    val symbolId: Int, // 종목 ID(btc/eth, krw/btc 등과 같은 관계를 정의하는 ID
    val description: String, // 설명
    val symbolType: SymbolType, // 현물, 선물, 옵션
    val baseCurrency: Int, // 기준화폐
    val quoteCurrency: Int, // 상대화폐
    val baseToQuoteRatio: Long, // 기준화폐 대 상대화폐 비율(1:x)
    val minimumQuoteTradingUnit: Long, // 최소 거래 가능 단위(1000설정 시 0.001 단위로 거래 가능)
    val takerFee: Long, // taker(시장가 주문하는 사람들) 수수료
    val makerFee: Long // maker(지정가 주문하는 사람들) 수수료
) {
    DOLLAR_XBT(
        symbolId = 1,
        description = "달러/비트",
        symbolType = SymbolType.CURRENCY_EXCHANGE_PAIR,
        baseCurrency = Currency.DOLLAR.id,
        quoteCurrency = Currency.XBT.id,
        baseToQuoteRatio = 100, //1원 : 100bit
        minimumQuoteTradingUnit = 1L, //최소단위는 1개
        takerFee = 0L,
        makerFee = 0L
    ),
    DOLLAR_ETH(
        symbolId = 2,
        description = "달러/이더",
        symbolType = SymbolType.CURRENCY_EXCHANGE_PAIR,
        baseCurrency = Currency.DOLLAR.id,
        quoteCurrency = Currency.ETH.id,
        baseToQuoteRatio = 50, //1원 : 50이더
        minimumQuoteTradingUnit = 1L, //최소단위는 1개
        takerFee = 0L,
        makerFee = 0L
    )
    ;

    companion object {
        private val map = values().associateBy(Symbol::name)
        fun from(code: String) = map[code]
    }
//    XBT_DOLLAR,
//    XBT_ETH,
//    ETH_DOLLAR,
//    ETH_XBT
}