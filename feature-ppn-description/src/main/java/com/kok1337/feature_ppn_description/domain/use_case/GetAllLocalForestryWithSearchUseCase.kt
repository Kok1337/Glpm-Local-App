package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.data.repository.LocalForestryTermuxRepository
import com.kok1337.address.domain.model.Forestry
import com.kok1337.address.domain.model.LocalForestry
import javax.inject.Inject

internal class GetAllLocalForestryWithSearchUseCase @Inject constructor(
    private val localForestryTermuxRepository: LocalForestryTermuxRepository,
) {
    suspend operator fun invoke(
        forestry: Forestry,
        search: String = ""
    ): List<LocalForestry> {
        return localForestryTermuxRepository
            .findAllByForestryIdWithSearch(forestry.id, search)
            .toList()
    }
}