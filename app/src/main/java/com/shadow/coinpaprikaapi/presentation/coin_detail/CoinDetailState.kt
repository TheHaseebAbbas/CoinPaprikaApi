package com.shadow.coinpaprikaapi.presentation.coin_detail

import com.shadow.coinpaprikaapi.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
