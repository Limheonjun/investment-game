package com.emgc.indicatorservice.service.upbit

import com.emgc.indicatorservice.dto.upbit.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitWeekCandleRequest
import com.emgc.indicatorservice.dto.upbit.response.UpbitDayCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitMinuteCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitMonthCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitWeekCandleResponse

interface UpbitCandleApiService {

    fun getMinuteCandle(
        unit: Int,
        request: UpbitMinuteCandleRequest
    ): Array<UpbitMinuteCandleResponse>?

    fun getDayCandle(
        request: UpbitDayCandleRequest
    ): Array<UpbitDayCandleResponse>?

    fun getWeekCandle(
        request: UpbitWeekCandleRequest
    ): Array<UpbitWeekCandleResponse>?

    fun getMonthCandle(
        request: UpbitMonthCandleRequest
    ): Array<UpbitMonthCandleResponse>?

}