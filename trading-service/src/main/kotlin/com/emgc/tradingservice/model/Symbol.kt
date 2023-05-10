package com.emgc.tradingservice.model

import com.emgc.tradingservice.model.enumeration.SymbolStatus
import exchange.core2.core.common.SymbolType
import java.math.BigDecimal

data class Symbol(
    val symbolId: Int,
    val symbolCode: String,
    val symbolType: SymbolType,
    val baseAsset: Asset,
    val quoteAsset: Asset,
    val lotSize: BigDecimal,
    val stepSize: BigDecimal,
    val takerFee: BigDecimal, // TODO check invariant: taker fee is not less than maker fee
    val makerFee: BigDecimal,
    val marginBuy: BigDecimal,
    val marginSell: BigDecimal,
    val priceHighLimit: BigDecimal,
    val priceLowLimit: BigDecimal,
    val status: SymbolStatus
)