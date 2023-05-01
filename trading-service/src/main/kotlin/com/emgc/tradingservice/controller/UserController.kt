package com.emgc.tradingservice.controller

import com.emgc.tradingservice.service.UserService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/users/{id}")
    fun createUser(@PathVariable id: Long) {
        userService.createUser(id)
    }
}