package com.shadow.coinpaprikaapi.domain.use_case.get_coins

import com.shadow.coinpaprikaapi.core.util.Resource
import com.shadow.coinpaprikaapi.domain.model.Coin
import com.shadow.coinpaprikaapi.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}