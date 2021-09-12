package com.kl3jvi.cryptoapp.domain.use_case.get_coins

import com.kl3jvi.cryptoapp.common.Resource
import com.kl3jvi.cryptoapp.data.remote.dto.toCoin
import com.kl3jvi.cryptoapp.domain.model.Coin
import com.kl3jvi.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(
                Resource.Error(e.localizedMessage ?: "An unexpected error occurred",
                    repository.getCoins().map { it.toCoin() })
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection.",
                    repository.getCoins().map { it.toCoin() })
            )
        }
    }
}