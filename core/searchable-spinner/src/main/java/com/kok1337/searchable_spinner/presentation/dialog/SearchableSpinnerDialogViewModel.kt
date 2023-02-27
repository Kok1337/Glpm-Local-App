package com.kok1337.searchable_spinner.presentation.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.searchable_spinner.domain.model.SortType
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.domain.usecase.GetDataForSearchableSpinnerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
internal class SearchableSpinnerDialogViewModel<T>(
    private val getDataForSearchableSpinnerUseCase: GetDataForSearchableSpinnerUseCase<T>,
    private val sortTypes: Array<SortType>,
) : ViewModel() {

    private var currentSortTypeIndex: Int = 0
    private val initialSortType = if (sortTypes.isEmpty()) null else sortTypes[currentSortTypeIndex]

    private val query = MutableStateFlow("")
    private val _selectedSortType = MutableStateFlow(initialSortType)
    val selectedSortType = _selectedSortType.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            query.debounce(50).onEach {
                _items.value =
                    getDataForSearchableSpinnerUseCase.invoke(query.value, selectedSortType.value)
            }.collect()

            selectedSortType.debounce(50).onEach {
                _items.value =
                    getDataForSearchableSpinnerUseCase.invoke(query.value, selectedSortType.value)
            }.collect()
        }
    }

    private val _items = MutableStateFlow<List<T>>(emptyList())
    val items = _items.asStateFlow()

    fun nextSortType() {
        currentSortTypeIndex = (currentSortTypeIndex + 1) % sortTypes.size
        _selectedSortType.value = sortTypes[currentSortTypeIndex]
    }

    fun setQuery(value: String) {
        query.value = value
    }

    class SearchableSpinnerDialogViewModelFactory<E>(
        private val repository: SearchableSpinnerRepository<E>,
        private val sortTypes: Array<SortType>,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchableSpinnerDialogViewModel(
                GetDataForSearchableSpinnerUseCase(repository),
                sortTypes
            ) as T
        }
    }
}