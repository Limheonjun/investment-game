package com.emgc.indicatorservice

import java.time.LocalDateTime

interface Indicator {

    fun getRelativeStrengthIndex(
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    )

    fun getStochastic(
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    )

}