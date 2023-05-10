package com.emgc.tradingservice.model.enumeration

enum class AssetStatus(
    val description: String
) {
    NEW("신규"),
    ACTIVE("활성화"),
    INACTIVE("비활성화")
}