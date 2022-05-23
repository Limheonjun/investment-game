package com.emgc.indicatorservice.dto.upbit.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UpbitDayCandleResponse(
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

    @JsonProperty(value = "prev_closing_price")
    val prevClosingPrice: Double,

    @JsonProperty(value = "change_price")
    val changePrice: Double,

    @JsonProperty(value = "change_rate")
    val changeRate: Double,

    @JsonProperty(value = "converted_trade_price")
    val convertedTradePrice1: Double,
)