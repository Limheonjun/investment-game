package com.emgc.tradingservice.model

import com.emgc.tradingservice.model.enumeration.AssetCode
import com.emgc.tradingservice.model.enumeration.AssetStatus

data class Asset(
    val assetCode: AssetCode,
    val assetId: Long,
    val scale: Long,
    val status: AssetStatus
)