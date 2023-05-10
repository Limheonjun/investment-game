package com.emgc.tradingservice.model.enumeration
// TODO : DB에 저장
enum class AssetCode(
    val id: Long,
    val scale: Long, // 소수점 몇번째자리까지 소유 가능한지 여부
    val description: String
) {
    USDT(1, 2, "USD테더"),
    XBTC(2, 8, "비트코인")
}