package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.data.repository.RegionTermuxRepository
import com.kok1337.address.domain.model.FederalDistrict
import com.kok1337.address.domain.model.Region
import javax.inject.Inject

internal class GetAllRegionWithSearchUseCase @Inject constructor(
    private val regionTermuxRepository: RegionTermuxRepository,
) {
    suspend operator fun invoke(
        federalDistrict: FederalDistrict,
        search: String = ""
    ): List<Region> {
        return regionTermuxRepository
            .findAllByFederalDistrictIdWithSearch(federalDistrict.id, search)
            .toList()
    }
}