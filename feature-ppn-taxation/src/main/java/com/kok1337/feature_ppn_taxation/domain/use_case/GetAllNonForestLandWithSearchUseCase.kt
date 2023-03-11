package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.NonForestLandTermuxRepository
import com.kok1337.taxation.domain.model.NonForestLand
import javax.inject.Inject

internal class GetAllNonForestLandWithSearchUseCase @Inject constructor(
    private val nonForestLandTermuxRepository: NonForestLandTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<NonForestLand> {
        return nonForestLandTermuxRepository.findAllWithSearch(search).toList()
    }
}