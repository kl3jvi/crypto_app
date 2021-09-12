package com.kl3jvi.cryptoapp.data.remote

import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins()
}