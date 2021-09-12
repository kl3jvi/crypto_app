package com.kl3jvi.cryptoapp.domain.repository

import com.kl3jvi.cryptoapp.data.remote.dto.CoinDetailsDto
import com.kl3jvi.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}