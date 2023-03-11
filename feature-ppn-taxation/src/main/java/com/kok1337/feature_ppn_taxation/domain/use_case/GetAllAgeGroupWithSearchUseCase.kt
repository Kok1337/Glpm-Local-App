package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.AgeGroupTermuxRepository
import com.kok1337.taxation.domain.model.AgeGroup
import javax.inject.Inject

internal class GetAllAgeGroupWithSearchUseCase @Inject constructor(
    private val ageGroupTermuxRepository: AgeGroupTermuxRepository
) {
    suspend operator fun invoke(search: String): List<AgeGroup> {
        return ageGroupTermuxRepository.findAllWithSearch(search).toList()
    }
}