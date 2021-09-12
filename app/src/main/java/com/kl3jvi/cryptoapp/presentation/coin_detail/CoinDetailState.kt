package com.kl3jvi.cryptoapp.presentation.coin_detail

import com.kl3jvi.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)