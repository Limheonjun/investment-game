package com.emgc.indicatorservice.dto.upbit.request

data class UpbitDayCandleRequest(
    val market: String = "KRW-BTC",
    val to: String?,
    val count: Int?,
    val convertingPriceUnit: String?
)