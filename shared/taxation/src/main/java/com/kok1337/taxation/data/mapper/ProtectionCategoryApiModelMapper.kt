package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.ProtectionCategoryApiModel
import com.kok1337.taxation.domain.model.ProtectionCategory

internal object ProtectionCategoryApiModelMapper {
    fun toModel(protectionCategoryApiModel: ProtectionCategoryApiModel): ProtectionCategory {
        return ProtectionCategory(protectionCategoryApiModel.id, protectionCategoryApiModel.name)
    }
}