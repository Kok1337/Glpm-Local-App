package com.kok1337.taxation.data.mapper

import com.kok1337.taxation.data.model.TaxSourceApiModel
import com.kok1337.taxation.domain.model.TaxSource

internal object TaxSourceApiModelMapper {
    fun toModel(taxSourceApiModel: TaxSourceApiModel): TaxSource = TaxSource(
        taxSourceApiModel.id, taxSourceApiModel.name
    )
}