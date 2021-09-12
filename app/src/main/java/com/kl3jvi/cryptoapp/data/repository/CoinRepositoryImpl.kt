package com.kl3jvi.cryptoapp.data.repository

import com.kl3jvi.cryptoapp.data.remote.CoinPaprikaApi
import com.kl3jvi.cryptoapp.data.remote.dto.CoinDetailsDto
import com.kl3jvi.cryptoapp.data.remote.dto.CoinDto
import com.kl3jvi.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}