package com.emgc.indicatorservice.util.urlgenerator

import com.emgc.indicatorservice.dto.upbit.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitWeekCandleRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class UpbitUrlGenerator {

    companion object {
        private const val MARKET = "market"
        private const val TO = "to"
        private const val COUNT = "count"
        private const val CONVERTING_PRICE_UNIT = "convertingPriceUnit"
    }

    @Value("\${upbit.base-url}")
    private lateinit var upditBaseUrl: String

    @Value("\${upbit.minute-candle-path}")
    private lateinit var minuteCandlePath: String

    @Value("\${upbit.day-candle-path}")
    private lateinit var dayCandlePath: String

    @Value("\${upbit.week-candle-path}")
    private lateinit var weekCandlePath: String

    @Value("\${upbit.month-candle-path}")
    private lateinit var monthCandlePath: String

    fun getMinuteCandleUrl(
        unit: Int,
        request: UpbitMinuteCandleRequest
    ): URI {
        val (market, to, count) = request

        val requestUrl = UriComponentsBuilder
            .fromUriString(getUpbitBaseUrl() + getMinuteCandlePath() + "/$unit")
            .queryParam(MARKET, market)

        to?.let { requestUrl.queryParam(TO, to) }
        count?.let { requestUrl.queryParam(COUNT, count) }

        return requestUrl.build().toUri()
    }

    fun getDayCandleUrl(
        request: UpbitDayCandleRequest
    ): URI {
        val (market, to, count, convertingPriceUnit) = request

        val requestUrl = UriComponentsBuilder
            .fromUriString(getUpbitBaseUrl() + getDayCandlePath())
            .queryParam(MARKET, market)

        to?.let { requestUrl.queryParam(TO, to) }
        count?.let { requestUrl.queryParam(COUNT, count) }
        convertingPriceUnit?.let { requestUrl.queryParam(CONVERTING_PRICE_UNIT, convertingPriceUnit) }

        return requestUrl.build().toUri()
    }

    fun getWeekCandleUrl(
        request: UpbitWeekCandleRequest
    ): URI {
        val (market, to, count) = request

        val requestUrl = UriComponentsBuilder
            .fromUriString(getUpbitBaseUrl() + getWeekCandlePath())
            .queryParam(MARKET, market)

        to?.let { requestUrl.queryParam(TO, to) }
        count?.let { requestUrl.queryParam(COUNT, count) }

        return requestUrl.build().toUri()
    }

    fun getMonthCandleUrl(
        request: UpbitMonthCandleRequest
    ): URI {
        val (market, to, count) = request

        val requestUrl = UriComponentsBuilder
            .fromUriString(getUpbitBaseUrl() + getMonthCandlePath())
            .queryParam(MARKET, market)

        to?.let { requestUrl.queryParam(TO, to) }
        count?.let { requestUrl.queryParam(COUNT, count) }

        return requestUrl.build().toUri()
    }

    private fun getUpbitBaseUrl(): String {
        return upditBaseUrl
    }

    private fun getMinuteCandlePath(): String {
        return minuteCandlePath
    }

    private fun getDayCandlePath(): String {
        return dayCandlePath
    }

    private fun getWeekCandlePath(): String {
        return weekCandlePath
    }

    private fun getMonthCandlePath(): String {
        return monthCandlePath
    }

}