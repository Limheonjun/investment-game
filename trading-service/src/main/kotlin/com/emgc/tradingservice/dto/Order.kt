package com.emgc.tradingservice.dto

import com.emgc.tradingservice.enums.Symbol
import exchange.core2.core.common.OrderAction
import exchange.core2.core.common.OrderType

data class Order(
    val userId: Long,
    val price: Long,
    val reservePrice: Long,
    val size: Long,
    val action: OrderAction,
    val orderType: OrderType,
    val symbol: Symbol
)