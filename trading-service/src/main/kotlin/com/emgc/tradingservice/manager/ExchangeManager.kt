package com.emgc.tradingservice.manager

import com.emgc.tradingservice.model.Asset
import com.emgc.tradingservice.model.Symbol
import com.emgc.tradingservice.model.enumeration.AssetStatus
import com.emgc.tradingservice.model.enumeration.SymbolStatus
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ExchangeManager {
    private final val code2AssetMap = ConcurrentHashMap<String, Asset>()
    private final val id2AssetMap = ConcurrentHashMap<Long, Asset>()
    private final val code2SymbolMap = ConcurrentHashMap<String, Symbol>()
    private final val id2SymbolMap = ConcurrentHashMap<Long, Symbol>()

    fun getAssetByCode(assetCode: String) = code2AssetMap[assetCode]
    fun getAssetById(assetId: Long) = id2AssetMap[assetId]
    fun getActiveAssets() = code2AssetMap.values.filter { it.status == AssetStatus.ACTIVE }

    fun getSymbolByCode(symbolCode: String) = code2SymbolMap[symbolCode]
    fun getSymbolById(symbolId: Long) = id2SymbolMap[symbolId]
    fun getActiveSymbols() = code2SymbolMap.values.filter { it.status == SymbolStatus.ACTIVE }
}