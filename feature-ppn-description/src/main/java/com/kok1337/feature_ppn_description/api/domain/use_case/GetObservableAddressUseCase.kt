package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.Address
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetObservableAddressUseCase @Inject constructor(
    private val addressInMemoryRepository: AddressInMemoryRepository,
) {
    operator fun invoke(): Flow<Address> {
        return addressInMemoryRepository.getAddressFlow()
    }
}