package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.ForestPurposeTermuxRepository
import com.kok1337.taxation.domain.model.ForestPurpose
import javax.inject.Inject

internal class GetAllForestPurposeWithSearchUseCase @Inject constructor(
    private val forestPurposeTermuxRepository: ForestPurposeTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<ForestPurpose> {
        return forestPurposeTermuxRepository.findAllWithSearch(search).toList()
    }
}