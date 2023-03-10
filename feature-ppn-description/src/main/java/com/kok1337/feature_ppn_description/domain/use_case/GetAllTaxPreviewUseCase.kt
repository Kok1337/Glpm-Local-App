package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.taxation.data.repository.TaxPreviewTermuxRepository
import com.kok1337.taxation.domain.model.TaxPreview
import java.util.*
import javax.inject.Inject

internal class GetAllTaxPreviewUseCase @Inject constructor(
    private val taxPreviewTermuxRepository: TaxPreviewTermuxRepository,
) {
    suspend operator fun invoke(localityId: UUID, section: String): List<TaxPreview> {
        return taxPreviewTermuxRepository
            .findAllByLocalityIdAndSection(localityId, section)
            .toList()
    }
}