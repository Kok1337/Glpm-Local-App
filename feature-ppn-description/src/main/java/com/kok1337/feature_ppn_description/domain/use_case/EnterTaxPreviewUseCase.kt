package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.data.repository.DescriptionTaxInMemoryRepository
import com.kok1337.taxation.domain.model.TaxPreview
import javax.inject.Inject

internal class EnterTaxPreviewUseCase @Inject constructor(
    private val descriptionTaxInMemoryRepository: DescriptionTaxInMemoryRepository,
) {
    operator fun invoke(taxPreview: TaxPreview) {
        descriptionTaxInMemoryRepository.enterTaxPreview(taxPreview)
    }
}