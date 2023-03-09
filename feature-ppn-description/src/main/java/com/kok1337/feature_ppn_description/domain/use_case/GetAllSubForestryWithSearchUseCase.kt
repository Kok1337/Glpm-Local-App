package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.data.repository.SubForestryTermuxRepository
import com.kok1337.address.domain.model.LocalForestry
import com.kok1337.address.domain.model.SubForestry
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