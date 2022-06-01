package com.emgc.indicatorservice.dto.upbit.candle.request

data class UpbitMinuteCandleRequest(
    val market: String = "KRW-BTC",
    val to: String?,
    val count: Int?
)