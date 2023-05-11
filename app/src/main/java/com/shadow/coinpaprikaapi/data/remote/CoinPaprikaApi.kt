package com.shadow.coinpaprikaapi.data.remote

import com.shadow.coinpaprikaapi.data.remote.dto.CoinDetailDto
import com.shadow.coinpaprikaapi.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }
}