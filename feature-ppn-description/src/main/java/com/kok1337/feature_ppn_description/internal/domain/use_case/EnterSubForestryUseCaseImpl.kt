package com.kok1337.feature_ppn_description.internal.domain.use_case

import com.kok1337.feature_ppn_description.api.domain.module.SubForestry
import com.kok1337.feature_ppn_description.api.domain.use_case.EnterSubForestryUseCase
import com.kok1337.result.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EnterSubForestryUseCaseImpl @Inject constructor(

): EnterSubForestryUseCase {
    override suspend fun invoke(): Flow<DataResult<SubForestry>> {
        TODO("Not yet implemented")
    }
}