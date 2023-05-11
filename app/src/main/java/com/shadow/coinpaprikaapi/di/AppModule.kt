package com.shadow.coinpaprikaapi.di

import com.shadow.coinpaprikaapi.data.remote.CoinPaprikaApi
import com.shadow.coinpaprikaapi.data.remote.CoinPaprikaApi.Companion.BASE_URL
import com.shadow.coinpaprikaapi.data.repository.CoinPaprikaRepositoryImpl
import com.shadow.coinpaprikaapi.domain.repository.CoinPaprikaRepository
import com.shadow.coinpaprikaapi.domain.use_case.get_coin.GetCoinUseCase
import com.shadow.coinpaprikaapi.domain.use_case.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(repository: CoinPaprikaRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCoinByIdUseCase(repository: CoinPaprikaRepository): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaRepository(api: CoinPaprikaApi): CoinPaprikaRepository {
        return CoinPaprikaRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
}