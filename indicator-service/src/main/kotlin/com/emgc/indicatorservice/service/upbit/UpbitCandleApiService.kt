package com.emgc.indicatorservice.service.upbit

import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitWeekCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitDayCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitMinuteCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitMonthCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitWeekCandleResponse

interface UpbitCandleApiService {

    fun getMinuteCandle(
        unit: Int,
        request: UpbitMinuteCandleRequest
    ): List<UpbitMinuteCandleResponse>

    fun getDayCandle(
        request: UpbitDayCandleRequest
    ): List<UpbitDayCandleResponse>

    fun getWeekCandle(
        request: UpbitWeekCandleRequest
    ): List<UpbitWeekCandleResponse>

    fun getMonthCandle(
        request: UpbitMonthCandleRequest
    ): List<UpbitMonthCandleResponse>

}