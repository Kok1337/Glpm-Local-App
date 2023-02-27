package com.kok1337.protection_category.api.use_case

import com.kok1337.protection_category.api.ProtectionCategoryRepository
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.protection_category.internal.mapper.ProtectionCategoryMapper

class GetProtectionCategoryByIdUseCase(
    private val protectionCategoryRepository: ProtectionCategoryRepository,
) {
    suspend operator fun invoke(id: Int): ProtectionCategory {
        val apiModel = protectionCategoryRepository.findById(id)
        return ProtectionCategoryMapper.fromApiModel(apiModel)
    }
}