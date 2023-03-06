package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import javax.inject.Inject

internal class EnterAreaUseCase @Inject constructor(
    private val addressInMemoryRepository: AddressInMemoryRepository,
) {
    operator fun invoke(area: String?) {
        addressInMemoryRepository.updateArea(area)
    }
}