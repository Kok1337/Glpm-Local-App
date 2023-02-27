package com.kok1337.protection_category.internal.mapper

import com.kok1337.protection_category.api.ProtectionCategoryApiModel
import com.kok1337.protection_category.api.model.ProtectionCategory

internal object ProtectionCategoryMapper {
    fun fromApiModel(apiModel: ProtectionCategoryApiModel): ProtectionCategory {
        return ProtectionCategory(apiModel.id, apiModel.name)
    }
}