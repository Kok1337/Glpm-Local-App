package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import java.util.*
import javax.inject.Inject

internal class DeleteTaxLayerByIdUseCase @Inject constructor(
    private val taxationTaxLayerInMemoryRepository: TaxationTaxLayerInMemoryRepository,
) {
    operator fun invoke(id: UUID) {
        taxationTaxLayerInMemoryRepository.deleteTaxLayer(id)
    }
}