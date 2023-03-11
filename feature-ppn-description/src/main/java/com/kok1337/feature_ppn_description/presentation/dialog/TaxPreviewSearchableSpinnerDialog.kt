package com.kok1337.feature_ppn_description.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.TaxPreview

class TaxPreviewSearchableSpinnerDialog(
    searchableSpinnerRepository: SearchableSpinnerRepository<TaxPreview>,
    onItemSelected: OnItemSelected<TaxPreview>,
) : SimpleSearchableSpinnerDialog<TaxPreview>(
    title = "Выберите ТО",
    selectedItem = null,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: TaxPreview -> "S = ${item.s}, Год = ${item.forestInventoryYear}, Источник = ${item.taxSource?.name}" },
    onItemSelected = onItemSelected,
)