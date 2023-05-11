package com.shadow.coinpaprikaapi.data.repository

import com.shadow.coinpaprikaapi.core.util.Resource
import com.shadow.coinpaprikaapi.data.remote.CoinPaprikaApi
import com.shadow.coinpaprikaapi.domain.model.Coin
import com.shadow.coinpaprikaapi.domain.model.CoinDetail
import com.shadow.coinpaprikaapi.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinPaprikaRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinPaprikaRepository {
    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        try {
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unknown error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        try {
            val coin = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unknown error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}