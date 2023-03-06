package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.SubForestry
import javax.inject.Inject

internal class EnterSubForestryUseCase @Inject constructor(
    private val addressInMemoryRepository: AddressInMemoryRepository,
) {
    operator fun invoke(subForestry: SubForestry?) {
        addressInMemoryRepository.updateSubForestry(subForestry)
    }
}