package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.ProtectionCategory

class ProtectionCategorySearchableSpinnerDialog(
    selectedProtectionCategory: ProtectionCategory?,
    searchableSpinnerRepository: SearchableSpinnerRepository<ProtectionCategory>,
    onItemSelected: OnItemSelected<ProtectionCategory>,
) : SimpleSearchableSpinnerDialog<ProtectionCategory>(
    title = "Выберите Категорию защитности",
    selectedItem = selectedProtectionCategory,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: ProtectionCategory -> item.name },
    onItemSelected = onItemSelected,
)