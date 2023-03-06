package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.data.repository.ForestryTermuxRepository
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import com.kok1337.feature_ppn_description.api.domain.module.Region
import javax.inject.Inject

internal class GetAllForestryWithSearchUseCase @Inject constructor(
    private val forestryTermuxRepository: ForestryTermuxRepository,
) {
    suspend operator fun invoke(
        region: Region,
        search: String = ""
    ): List<Forestry> {
        return forestryTermuxRepository
            .findAllByRegionIdWithSearch(region.id, search)
            .toList()
    }
}