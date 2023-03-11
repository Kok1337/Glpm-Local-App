package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.UnforestedLandTermuxRepository
import com.kok1337.taxation.domain.model.UnforestedLand
import javax.inject.Inject

internal class GetAllUnforestedLandWithSearchUseCase @Inject constructor(
    private val unforestedLandTermuxRepository: UnforestedLandTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<UnforestedLand> {
        return unforestedLandTermuxRepository.findAllWithSearch(search).toList()
    }
}