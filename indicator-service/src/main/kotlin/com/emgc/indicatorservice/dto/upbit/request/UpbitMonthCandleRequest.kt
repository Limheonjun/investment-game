package com.emgc.indicatorservice.dto.upbit.request

data class UpbitMonthCandleRequest(
    val market: String = "KRW-BTC",
    val to: String?,
    val count: Int?
)