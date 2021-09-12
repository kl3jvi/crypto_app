package com.kl3jvi.cryptoapp.data.remote

import com.kl3jvi.cryptoapp.data.remote.dto.CoinDetailsDto
import com.kl3jvi.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinsId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto
}