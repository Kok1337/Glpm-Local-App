package com.kok1337.searchable_spinner.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.app_listeners.AppSearchViewListener
import com.kok1337.searchable_spinner.R
import com.kok1337.searchable_spinner.databinding.DialogSearchableSpinnerBinding
import com.kok1337.searchable_spinner.domain.model.SortType
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.adapter.OnItemClicked
import com.kok1337.searchable_spinner.presentation.adapter.SearchableSpinnerBindingAdapter
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


open class SearchableSpinnerDialog<T>(
    private val title: String = "Заголовок",
    private val searchableSpinnerAdapter: SearchableSpinnerBindingAdapter<T, *>,
    searchableSpinnerRepository: SearchableSpinnerRepository<T>,
    private val nullSelection: Boolean = true,
    private val sortTypes: Array<SortType> = emptyArray(),
    private val onItemSelected: OnItemSelected<T>,
) : DialogFragment(R.layout.dialog_searchable_spinner) {

    private val binding by viewBinding(DialogSearchableSpinnerBinding::bind)

    @FlowPreview
    private val viewModelFactory =
        SearchableSpinnerDialogViewModel.SearchableSpinnerDialogViewModelFactory(
            searchableSpinnerRepository,
            sortTypes
        )

    @FlowPreview
    private lateinit var viewModel: SearchableSpinnerDialogViewModel<T>

    @Suppress("UNCHECKED_CAST")
    @FlowPreview
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[SearchableSpinnerDialogViewModel::class.java] as SearchableSpinnerDialogViewModel<T>
    }

    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchableSpinnerAdapter.onItemClicked = adapterListener
        binding.listView.adapter = searchableSpinnerAdapter
        binding.listView.layoutManager = LinearLayoutManager(context)
        binding.titleTextView.text = title
        binding.nullSelection.visibility = if (nullSelection) View.VISIBLE else View.GONE
        binding.nullSelection.setOnClickListener { selectNull() }
        binding.sortIcon.visibility = if (sortTypes.isEmpty()) View.GONE else View.VISIBLE
        binding.sortIcon.setOnClickListener { viewModel.nextSortType() }
        binding.searchView.setOnQueryTextListener(AppSearchViewListener { query ->
            viewModel.setQuery(query!!)
        })

        lifecycleScope.launchWhenStarted {
            viewModel.selectedSortType
                .onEach { setupSortType(it) }
                .collect()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.items
                .onEach { updateAdapterItems(it) }
                .collect()
        }
    }

    private fun setupSortType(sortType: SortType?) {
        if (sortType == null) return
        binding.sortIcon.setImageResource(sortType.iconResource)
    }

    private fun updateAdapterItems(items: List<T>) {
        searchableSpinnerAdapter.items = items
    }

    private val adapterListener = OnItemClicked<T> { item -> selectClickedItem(item) }

    private fun selectClickedItem(selectedItem: T?) {
        onItemSelected.invoke(selectedItem)
        closeDialog()
    }

    private fun selectNull() = selectClickedItem(null)

    private fun closeDialog() {
        dismiss()
    }
}
