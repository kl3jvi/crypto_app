package com.kl3jvi.cryptoapp.domain.use_case.get_coin

import com.kl3jvi.cryptoapp.common.Resource
import com.kl3jvi.cryptoapp.data.remote.dto.toCoinDetail
import com.kl3jvi.cryptoapp.domain.model.CoinDetail
import com.kl3jvi.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occurred",
                    repository.getCoinById(coinId).toCoinDetail()
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection.",
                    repository.getCoinById(coinId).toCoinDetail()
                )
            )
        }
    }
}