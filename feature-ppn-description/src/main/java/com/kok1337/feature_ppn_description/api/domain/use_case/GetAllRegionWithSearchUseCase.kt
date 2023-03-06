package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.data.repository.RegionTermuxRepository
import com.kok1337.feature_ppn_description.api.domain.module.FederalDistrict
import com.kok1337.feature_ppn_description.api.domain.module.Region
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