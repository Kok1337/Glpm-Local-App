package com.kok1337.feature_ppn_description.api.domain.use_case

import com.kok1337.feature_ppn_description.api.data.repository.SubForestryTermuxRepository
import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry
import com.kok1337.feature_ppn_description.api.domain.module.SubForestry
import javax.inject.Inject

internal class GetAllSubForestryWithSearchUseCase @Inject constructor(
    private val subForestryTermuxRepository: SubForestryTermuxRepository,
) {
    suspend operator fun invoke(
        localForestry: LocalForestry,
        search: String = ""
    ): List<SubForestry> {
        return subForestryTermuxRepository
            .findAllByLocalForestryIdWithSearch(localForestry.id, search)
            .toList()
    }
}