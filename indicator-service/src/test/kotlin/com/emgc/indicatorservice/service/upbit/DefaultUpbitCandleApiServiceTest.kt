package com.emgc.indicatorservice.service.upbit

import com.emgc.indicatorservice.dto.upbit.request.UpbitDayCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMinuteCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitMonthCandleRequest
import com.emgc.indicatorservice.dto.upbit.request.UpbitWeekCandleRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@DisplayName("업비트 캔들 API 테스트")
internal class DefaultUpbitCandleApiServiceTest {

    @Autowired
    lateinit var upbitCandleApiService: DefaultUpbitCandleApiService

    @Test
    @DisplayName("분캔들 API를 호출했을 경우 데이터를 정상적으로 반환해야한다.")
    fun getMinuteCandle() {
        //given
        val unit = 1
        val request = UpbitMinuteCandleRequest(
            market = "KRW-BTC",
            to = null,
            count = 3
        )

        //whenn
        val response = upbitCandleApiService.getMinuteCandle(unit, request)

        //then
        Assertions.assertNotNull(response)
        Assertions.assertNotEquals(0, response!!.size)
    }

    @Test
    @DisplayName("일캔들 API를 호출했을 경우 데이터를 정상적으로 반환해야한다.")
    fun getDayCandle() {
        //given
        val request = UpbitDayCandleRequest(
            market = "KRW-BTC",
            to = null,
            count = 3,
            convertingPriceUnit = null
        )

        //when
        val response = upbitCandleApiService.getDayCandle(request)

        //then
        Assertions.assertNotNull(response)
        Assertions.assertNotEquals(0, response!!.size)
    }

    @Test
    @DisplayName("주캔들 API를 호출했을 경우 데이터를 정상적으로 반환해야한다.")
    fun getWeekCandle() {
        //given
        val request = UpbitWeekCandleRequest(
            market = "KRW-BTC",
            to = null,
            count = 3
        )

        //whenn
        val response = upbitCandleApiService.getWeekCandle(request)

        //then
        Assertions.assertNotNull(response)
        Assertions.assertNotEquals(0, response!!.size)
    }

    @Test
    @DisplayName("월캔들 API를 호출했을 경우 데이터를 정상적으로 반환해야한다.")
    fun getMonthCandle() {
        //given
        val request = UpbitMonthCandleRequest(
            market = "KRW-BTC",
            to = null,
            count = 3
        )

        //whenn
        val response = upbitCandleApiService.getMonthCandle(request)

        //then
        Assertions.assertNotNull(response)
        Assertions.assertNotEquals(0, response!!.size)
    }
}