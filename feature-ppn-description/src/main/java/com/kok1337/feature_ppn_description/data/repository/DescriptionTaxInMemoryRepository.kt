package com.kok1337.feature_ppn_description.data.repository

import com.kok1337.taxation.domain.model.Tax
import com.kok1337.taxation.domain.model.TaxPreview
import kotlinx.coroutines.flow.StateFlow

interface DescriptionTaxInMemoryRepository {
    fun getTaxStateFlow(): StateFlow<Tax?>
    fun enterTaxPreview(taxPreview: TaxPreview)
}