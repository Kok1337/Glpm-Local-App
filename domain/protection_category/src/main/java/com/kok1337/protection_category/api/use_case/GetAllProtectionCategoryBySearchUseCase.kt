package com.kok1337.protection_category.api.use_case

import com.kok1337.protection_category.api.ProtectionCategoryRepository
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.protection_category.internal.mapper.ProtectionCategoryMapper

class GetAllProtectionCategoryBySearchUseCase(
    private val protectionCategoryRepository: ProtectionCategoryRepository,
) {
    suspend operator fun invoke(search: String): List<ProtectionCategory> {
        val apiModelList = protectionCategoryRepository.findAllWithSearch(search)
        return apiModelList.map(ProtectionCategoryMapper::fromApiModel)
    }
}