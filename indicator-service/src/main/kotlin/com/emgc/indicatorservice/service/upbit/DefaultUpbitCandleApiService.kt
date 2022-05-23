package com.emgc.indicatorservice.service.upbit

import com.emgc.indicatorservice.dto.upbit.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitWeekCandleRequest
import com.emgc.indicatorservice.dto.upbit.response.UpbitDayCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitMinuteCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitMonthCandleResponse
import com.emgc.indicatorservice.dto.upbit.response.UpbitWeekCandleResponse
import com.emgc.indicatorservice.util.urlgenerator.UpbitUrlGenerator
import mu.KLogging
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class DefaultUpbitCandleApiService(
    private val webClient: WebClient,
    private val upbitUrlGenerator: UpbitUrlGenerator
): UpbitCandleApiService {

    companion object {
        private val log = KLogging()
    }

    override fun getMinuteCandle(
        unit: Int,
        request: UpbitMinuteCandleRequest
    ): Array<UpbitMinuteCandleResponse>? {
        val requestUrl = upbitUrlGenerator.getMinuteCandleUrl(unit, request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Array<UpbitMinuteCandleResponse>::class.java)
            .block()
    }

    override fun getDayCandle(
        request: UpbitDayCandleRequest
    ): Array<UpbitDayCandleResponse>? {
        val requestUrl = upbitUrlGenerator.getDayCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Array<UpbitDayCandleResponse>::class.java)
            .block()
    }

    override fun getWeekCandle(
        request: UpbitWeekCandleRequest
    ): Array<UpbitWeekCandleResponse>? {
        val requestUrl = upbitUrlGenerator.getWeekCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Array<UpbitWeekCandleResponse>::class.java)
            .block()
    }

    override fun getMonthCandle(
        request: UpbitMonthCandleRequest
    ): Array<UpbitMonthCandleResponse>? {
        val requestUrl = upbitUrlGenerator.getMonthCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Array<UpbitMonthCandleResponse>::class.java)
            .block()
    }

}