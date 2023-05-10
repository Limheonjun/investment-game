package com.emgc.tradingservice.model.enumeration

import exchange.core2.core.common.SymbolType
import java.math.BigDecimal

enum class SymbolCode(
    val id: Long,
    val type: SymbolType,
    val baseAsset: AssetCode,
    val quoteAsset: AssetCode,
    val lotSize: BigDecimal,
    val stepSize: BigDecimal,
    val takerFee: BigDecimal,
    val makerFee: BigDecimal,
    val marginBuy: BigDecimal,
    val marginSell: BigDecimal,
    val priceHighLimit: BigDecimal,
    val priceLowLimit: BigDecimal,
    val status: SymbolStatus
) {
    XBTC_USDT(
        1,
        SymbolType.CURRENCY_EXCHANGE_PAIR,
        AssetCode.XBTC,
        AssetCode.USDT,
        BigDecimal("1"),
        BigDecimal("0.01"),
        BigDecimal("0.08"),
        BigDecimal("0.03"),
        BigDecimal("0"),
        BigDecimal("0"),
        BigDecimal("0"),
        BigDecimal("0"),
        SymbolStatus.ACTIVE
    )
}