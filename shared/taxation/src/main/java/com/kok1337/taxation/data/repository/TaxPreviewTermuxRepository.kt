package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.TaxDao
import com.kok1337.taxation.data.mapper.TaxApiModelMapper
import com.kok1337.taxation.domain.model.TaxPreview
import java.util.*

class TaxPreviewTermuxRepository(
    private val taxDao: TaxDao,
    private val taxSourceTermuxRepository: TaxSourceTermuxRepository,
) {
    suspend fun findAllByLocalityIdAndSection(
        localityId: UUID,
        section: String
    ): Iterable<TaxPreview> {
        return taxDao.getAllByLocalityIdAndSection(localityId, section).map { taxApiModel ->
            val taxSource = taxSourceTermuxRepository.findById(taxApiModel.dataSourceId)
            TaxApiModelMapper.toModel(
                taxApiModel = taxApiModel,
                taxSource = taxSource!!
            )
        }
    }
}