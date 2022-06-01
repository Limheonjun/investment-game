package com.emgc.indicatorservice.service.upbit

import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.request.UpbitWeekCandleRequest
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitDayCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitMinuteCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitMonthCandleResponse
import com.emgc.indicatorservice.dto.upbit.candle.response.UpbitWeekCandleResponse
import com.emgc.indicatorservice.util.urlgenerator.UpbitUrlGenerator
import mu.KLogging
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class DefaultUpbitCandleApiService(
    private val webClient: WebClient,
    private val upbitUrlGenerator: UpbitUrlGenerator
): UpbitCandleApiService {

    override fun getMinuteCandle(
        unit: Int,
        request: UpbitMinuteCandleRequest
    ): List<UpbitMinuteCandleResponse> {
        val requestUrl = upbitUrlGenerator.getMinuteCandleUrl(unit, request)
        
        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(object: ParameterizedTypeReference<List<UpbitMinuteCandleResponse>>() {})
            .block()!!
    }

    override fun getDayCandle(
        request: UpbitDayCandleRequest
    ): List<UpbitDayCandleResponse> {
        val requestUrl = upbitUrlGenerator.getDayCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(object: ParameterizedTypeReference<List<UpbitDayCandleResponse>>() {})
            .block()!!
    }

    override fun getWeekCandle(
        request: UpbitWeekCandleRequest
    ): List<UpbitWeekCandleResponse> {
        val requestUrl = upbitUrlGenerator.getWeekCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(object: ParameterizedTypeReference<List<UpbitWeekCandleResponse>>() {})
            .block()!!
    }

    override fun getMonthCandle(
        request: UpbitMonthCandleRequest
    ): List<UpbitMonthCandleResponse> {
        val requestUrl = upbitUrlGenerator.getMonthCandleUrl(request)

        return webClient
            .get()
            .uri(requestUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(object: ParameterizedTypeReference<List<UpbitMonthCandleResponse>>() {})
            .block()!!
    }

}