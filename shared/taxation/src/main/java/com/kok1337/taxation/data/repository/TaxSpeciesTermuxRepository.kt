package com.kok1337.taxation.data.repository

import com.kok1337.taxation.data.data_source.termux.dao.TaxSpeciesDao
import com.kok1337.taxation.data.mapper.TaxSpeciesApiModelMapper
import com.kok1337.taxation.domain.model.TaxSpecies
import java.util.*

class TaxSpeciesTermuxRepository(
    private val taxSpeciesDao: TaxSpeciesDao,
) {
    suspend fun findAllByParentId(taxLayerId: UUID): Iterable<TaxSpecies> {
        return taxSpeciesDao.getAllByParentId(taxLayerId).map(TaxSpeciesApiModelMapper::toModel)
    }
}