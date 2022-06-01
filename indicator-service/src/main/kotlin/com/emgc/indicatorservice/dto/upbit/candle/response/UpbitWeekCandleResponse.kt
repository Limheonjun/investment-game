package com.emgc.indicatorservice.dto.upbit.candle.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UpbitWeekCandleResponse(
    val market: String,

    @JsonProperty(value = "candle_date_time_utc")
    val candleDateTimeUTC: String,

    @JsonProperty(value = "candle_date_time_kst")
    val candleDateTimeKst: String,

    @JsonProperty(value = "opening_price")
    val openingPrice: Double,

    @JsonProperty(value = "high_price")
    val highPrice: Double,

    @JsonProperty(value = "low_price")
    val lowPrice: Double,

    @JsonProperty(value = "trade_price")
    val tradePrice: Double,

    val timestamp: Long,

    @JsonProperty(value = "candle_acc_trade_price")
    val candleAccTradePrice: Double,

    @JsonProperty(value = "candle_acc_trade_volume")
    val candleAccTradeVolume: Double,

    @JsonProperty(value = "first_day_of_period")
    val firstDayOfPeriod: String
)