package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry
import com.kok1337.result.DataResult
import kotlinx.coroutines.flow.Flow

interface EnterLocalForestryUseCase {
    suspend operator fun invoke(): Flow<DataResult<LocalForestry>>
}