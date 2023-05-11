package com.shadow.coinpaprikaapi.domain.repository

import com.shadow.coinpaprikaapi.core.util.Resource
import com.shadow.coinpaprikaapi.data.remote.dto.CoinDetailDto
import com.shadow.coinpaprikaapi.data.remote.dto.CoinDto
import com.shadow.coinpaprikaapi.domain.model.Coin
import com.shadow.coinpaprikaapi.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinPaprikaRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}