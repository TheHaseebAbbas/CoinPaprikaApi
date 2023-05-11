package com.shadow.coinpaprikaapi.domain.use_case.get_coin

import com.shadow.coinpaprikaapi.core.util.Resource
import com.shadow.coinpaprikaapi.domain.model.CoinDetail
import com.shadow.coinpaprikaapi.domain.repository.CoinPaprikaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinPaprikaRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinById(coinId)
    }
}