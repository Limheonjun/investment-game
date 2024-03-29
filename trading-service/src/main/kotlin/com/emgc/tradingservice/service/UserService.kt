package com.emgc.tradingservice.service

import exchange.core2.core.ExchangeCore
import exchange.core2.core.common.api.ApiAddUser
import org.springframework.stereotype.Service

@Service
class UserService(
    private val exchangeCore: ExchangeCore
) {
    fun initUser() {
        createUser(1)
        createUser(2)
    }
    private fun createUser(id: Long) {
        val user = ApiAddUser.builder()
            .uid(id)
            .build()

        exchangeCore.api.submitCommandAsync(user)
    }
}