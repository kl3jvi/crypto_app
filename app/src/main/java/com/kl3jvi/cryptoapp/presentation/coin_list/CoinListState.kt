package com.kl3jvi.cryptoapp.presentation.coin_list

import com.kl3jvi.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
