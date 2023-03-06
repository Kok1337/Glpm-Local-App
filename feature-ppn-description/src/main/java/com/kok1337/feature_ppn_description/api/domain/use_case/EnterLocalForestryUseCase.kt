package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry
import javax.inject.Inject

internal class EnterLocalForestryUseCase @Inject constructor(
    private val addressInMemoryRepository: AddressInMemoryRepository,
) {
    operator fun invoke(localForestry: LocalForestry?) {
        addressInMemoryRepository.updateLocalForestry(localForestry)
    }
}