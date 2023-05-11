package com.shadow.coinpaprikaapi.presentation.coin_list

import com.shadow.coinpaprikaapi.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
