package com.kok1337.feature_ppn_description.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.address.domain.model.*
import com.kok1337.dialog.presentation.dialog.InputStringDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_description.R
import com.kok1337.feature_ppn_description.databinding.FragmentPpnDescriptionBinding
import com.kok1337.feature_ppn_description.di.DaggerFeaturePpnDescriptionFragmentComponent
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItemAdapter
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_description.presentation.dialog.ForestrySearchableSpinnerDialog
import com.kok1337.feature_ppn_description.presentation.dialog.LocalForestrySearchableSpinnerDialog
import com.kok1337.feature_ppn_description.presentation.dialog.RegionSearchableSpinnerDialog
import com.kok1337.feature_ppn_description.presentation.dialog.SubForestrySearchableSpinnerDialog
import com.kok1337.providing_dependencies.findDependencies
import com.kok1337.searchable_spinner.domain.model.SortType
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import dagger.Lazy
import javax.inject.Inject

class PpnDescriptionFragment : Fragment(R.layout.fragment_ppn_description), AdapterListener {
    private val binding by viewBinding(FragmentPpnDescriptionBinding::bind)

    @Inject
    internal lateinit var viewModelFactory: Lazy<PpnDescriptionViewModel.Factory>
    private val viewModel: PpnDescriptionViewModel by viewModels {
        viewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeaturePpnDescriptionFragmentComponent.factory()
            .create(findDependencies())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descriptionItemAdapter = DescriptionItemAdapter(this)

        lifecycleScope.launchWhenStarted {
            lifecycleScope.launchWhenStarted {
                viewModel.descriptionItemListFlow.collect { descriptionItemAdapter.items = it }
            }
        }

        binding.recyclerView.adapter = descriptionItemAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onFederalDistrictClick(federalDistrict: FederalDistrict?) {}
    override fun onFederalDistrictLongClick(federalDistrict: FederalDistrict?) {
        TODO("Not yet implemented")
    }

    override fun onRegionClick(region: Region?) = openRegionDialog(region)
    override fun onRegionLongClick(region: Region?) {
        TODO("Not yet implemented")
    }

    override fun onForestryClick(forestry: Forestry?) = openForestryDialog(forestry)
    override fun onForestryLongClick(forestry: Forestry?) {
        TODO("Not yet implemented")
    }

    override fun onLocalForestryClick(localForestry: LocalForestry?) =
        openLocalForestryDialog(localForestry)

    override fun onLocalForestryLongClick(localForestry: LocalForestry?) {
        TODO("Not yet implemented")
    }

    override fun onSubForestryClick(subForestry: SubForestry?) = openSubForestryDialog(subForestry)
    override fun onSubForestryLongClick(subForestry: SubForestry?) {
        TODO("Not yet implemented")
    }

    override fun onAreaClick(area: String?) = openAreaDialog(area)
    override fun onAreaLongClick(area: String?) {
        TODO("Not yet implemented")
    }

    override fun onSectionClick(section: String?) {
        TODO("Not yet implemented")
    }

    override fun onSectionLongClick(section: String?) {
        TODO("Not yet implemented")
    }

    inner class RegionSearchableSpinnerRepository : SearchableSpinnerRepository<Region> {
        override suspend fun getAll(search: String, sortType: SortType?): List<Region> {
            return viewModel.getAllRegionBySearch(search)
        }
    }

    private fun openRegionDialog(region: Region?) {
        val repository = RegionSearchableSpinnerRepository()
        val dialog = RegionSearchableSpinnerDialog(region, repository) { newRegion ->
            viewModel.updateRegion(newRegion)
            if (newRegion != null) openForestryDialog(null)
        }
        showDialog(dialog, requireContext())
    }

    inner class ForestrySearchableSpinnerRepository : SearchableSpinnerRepository<Forestry> {
        override suspend fun getAll(search: String, sortType: SortType?): List<Forestry> {
            return viewModel.getAllForestryBySearch(search)
        }
    }

    private fun openForestryDialog(forestry: Forestry?) {
        val repository = ForestrySearchableSpinnerRepository()
        val dialog = ForestrySearchableSpinnerDialog(forestry, repository) { newForestry ->
            viewModel.updateForestry(newForestry)
            if (newForestry != null) openLocalForestryDialog(null)
        }
        showDialog(dialog, requireContext())
    }

    inner class LocalForestrySearchableSpinnerRepository :
        SearchableSpinnerRepository<LocalForestry> {
        override suspend fun getAll(search: String, sortType: SortType?): List<LocalForestry> {
            return viewModel.getAllLocalForestryWithSearch(search)
        }
    }

    private fun openLocalForestryDialog(localForestry: LocalForestry?) {
        val repository = LocalForestrySearchableSpinnerRepository()
        val dialog =
            LocalForestrySearchableSpinnerDialog(localForestry, repository) { newLocalForestry ->
                viewModel.updateLocalForestry(newLocalForestry)
                if (newLocalForestry != null) openSubForestryDialog(null)
            }
        showDialog(dialog, requireContext())
    }

    inner class SubForestrySearchableSpinnerRepository : SearchableSpinnerRepository<SubForestry> {
        override suspend fun getAll(search: String, sortType: SortType?): List<SubForestry> {
            return viewModel.getAllSubForestryWithSearch(search)
        }
    }

    private fun openSubForestryDialog(subForestry: SubForestry?) {
        val repository = SubForestrySearchableSpinnerRepository()
        val dialog = SubForestrySearchableSpinnerDialog(subForestry, repository) { newSubForestry ->
            viewModel.updateSubForestry(newSubForestry)
            if (newSubForestry != null) openAreaDialog(null)
        }
        showDialog(dialog, requireContext())
    }

    private fun openAreaDialog(area: String?) {
        val dialog = InputStringDialog(title = "Введите Квартал", startValue = area) { newArea ->
            viewModel.updateArea(newArea)
        }
        showDialog(dialog, requireContext())
    }
}