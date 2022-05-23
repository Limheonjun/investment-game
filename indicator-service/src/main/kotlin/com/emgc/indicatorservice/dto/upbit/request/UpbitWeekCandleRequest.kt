package com.emgc.indicatorservice.dto.upbit.request

data class UpbitWeekCandleRequest(
    val market: String = "KRW-BTC",
    val to: String?,
    val count: Int?
)