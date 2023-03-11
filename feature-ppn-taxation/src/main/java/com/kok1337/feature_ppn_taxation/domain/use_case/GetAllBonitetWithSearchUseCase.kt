package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.BonitetTermuxRepository
import com.kok1337.taxation.domain.model.Bonitet
import javax.inject.Inject

internal class GetAllBonitetWithSearchUseCase @Inject constructor(
    private val bonitetTermuxRepository: BonitetTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<Bonitet> {
        return bonitetTermuxRepository.findAllWithSearch(search).toList()
    }
}