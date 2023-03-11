package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.ProtectionCategoryTermuxRepository
import com.kok1337.taxation.domain.model.ProtectionCategory
import javax.inject.Inject

internal class GetAllProtectionCategoryWithSearchUseCase @Inject constructor(
    private val protectionCategoryTermuxRepository: ProtectionCategoryTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<ProtectionCategory> {
        return protectionCategoryTermuxRepository.findAllWithSearch(search).toList()
    }
}