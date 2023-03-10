package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.data.repository.TaxInMemoryRepository
import com.kok1337.taxation.domain.model.TaxPreview
import javax.inject.Inject

internal class EnterTaxPreviewUseCase @Inject constructor(
    private val taxInMemoryRepository: TaxInMemoryRepository,
) {
    operator fun invoke(taxPreview: TaxPreview) {
        taxInMemoryRepository.enterTaxPreview(taxPreview)
    }
}