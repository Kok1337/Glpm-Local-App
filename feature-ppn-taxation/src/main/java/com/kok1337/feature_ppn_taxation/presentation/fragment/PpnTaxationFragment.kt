package com.kok1337.feature_ppn_taxation.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.dialog.presentation.dialog.InputDoubleDialog
import com.kok1337.dialog.presentation.dialog.InputIntDialog
import com.kok1337.dialog.presentation.dialog.InputStringDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.R
import com.kok1337.feature_ppn_taxation.databinding.FragmentPpnTaxationBinding
import com.kok1337.feature_ppn_taxation.di.DaggerFeaturePpnTaxationFragmentComponent
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItemAdapter
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.presentation.dialog.*
import com.kok1337.providing_dependencies.findDependencies
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.species.domain.model.Species
import com.kok1337.taxation.domain.model.*
import dagger.Lazy
import java.util.*
import javax.inject.Inject

class PpnTaxationFragment : Fragment(R.layout.fragment_ppn_taxation), AdapterListener {
    private val binding by viewBinding(FragmentPpnTaxationBinding::bind)

    @Inject
    internal lateinit var viewModelFactory: Lazy<PpnTaxationViewModel.Factory>
    private val viewModel: PpnTaxationViewModel by viewModels {
        viewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeaturePpnTaxationFragmentComponent.factory().create(findDependencies()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taxationItemAdapter = TaxationItemAdapter(this)

        lifecycleScope.launchWhenStarted {
            viewModel.taxationItemListStateFlow.collect { taxationItemAdapter.items = it }
        }

        binding.recyclerView.adapter = taxationItemAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onNotCoveredForestClick(isCovered: Boolean) =
        viewModel.updateIsCoveredForest(isCovered)

    override fun onLandClick(land: Land?) {
        val repository = SearchableSpinnerRepository { _, _ ->
            viewModel.getAllLandUseCase()
        }
        val dialog = LandSearchableSpinnerDialog(land, repository) {
            viewModel.updateLand(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onUnforestedLandClick(unforestedLand: UnforestedLand?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllUnforestedLandWithSearchUseCase(search)
        }
        val dialog = UnforestedLandSearchableSpinnerDialog(unforestedLand, repository) {
            viewModel.enterTaxUnforestedLandUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onNonForestLandClick(nonForestLand: NonForestLand?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllNonForestLandWithSearchUseCase(search)
        }
        val dialog = NonForestLandSearchableSpinnerDialog(nonForestLand, repository) {
            viewModel.enterTaxNonForestLandUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onForestPurposeClick(forestPurpose: ForestPurpose?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllForestPurposeWithSearchUseCase(search)
        }
        val dialog = ForestPurposeSearchableSpinnerDialog(forestPurpose, repository) {
            viewModel.enterTaxForestPurposeUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onProtectionCategoryClick(protectionCategory: ProtectionCategory?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllProtectionCategoryWithSearchUseCase(search)
        }
        val dialog = ProtectionCategorySearchableSpinnerDialog(protectionCategory, repository) {
            viewModel.enterTaxProtectionCategoryUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onBonitetClick(bonitet: Bonitet?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllBonitetWithSearchUseCase(search)
        }
        val dialog = BonitetSearchableSpinnerDialog(bonitet, repository) {
            viewModel.enterTaxBonitetUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onForestTypeClick(forestType: String?) {
        val dialog = InputStringDialog(
            title = "Введите Тип леса",
            startValue = forestType,
            isNullable = true,
        ) { viewModel.enterTaxForestTypeUseCase(it) }
        showDialog(dialog, requireContext())
    }

    override fun onOzuClick(ozu: Ozu?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllOzuWithSearchUseCase(search)
        }
        val dialog = OzuSearchableSpinnerDialog(ozu, repository) {
            viewModel.enterTaxOzuUseCase(it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onTaxLayerHeightClick(taxLayerId: UUID, height: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Высоту",
            startValue = height,
            isNullable = true,
        ) { viewModel.enterTaxLayerHeightByIdUseCase(taxLayerId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onAgeClassClick(taxLayerId: UUID, ageClass: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Класс возраста",
            startValue = ageClass,
            isNullable = true,
        ) { viewModel.enterTaxLayerAgeClassByIdUseCase(taxLayerId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onAgeGroupClick(taxLayerId: UUID, ageGroup: AgeGroup?) {
        val repository = SearchableSpinnerRepository { search, _ ->
            viewModel.getAllAgeGroupWithSearchUseCase(search)
        }
        val dialog = AgeGroupSearchableSpinnerDialog(ageGroup, repository) {
            viewModel.enterTaxLayerAgeGroupByIdUseCase(taxLayerId, it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onFullnessClick(taxLayerId: UUID, fullness: Double?) {
        val dialog = InputDoubleDialog(
            title = "Введите Полноту",
            startValue = fullness,
            isNullable = true,
        ) { viewModel.enterTaxLayerFullnessByIdUseCase(taxLayerId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onStockClick(taxLayerId: UUID, stock: Double?) {
        val dialog = InputDoubleDialog(
            title = "Введите Запас",
            startValue = stock,
            isNullable = true,
        ) { viewModel.enterTaxLayerStockByIdUseCase(taxLayerId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onDeleteTaxLayerClick(taxLayerId: UUID) {
        viewModel.deleteTaxLayerByIdUseCase(taxLayerId)
    }

    override fun onSpeciesClick(taxLayerSpeciesId: UUID, species: Species?) {
        val repository = SearchableSpinnerRepository { _, _ ->
            viewModel.getAllSpeciesUseCase()
        }
        val dialog = SpeciesSearchableSpinnerDialog(species, repository) {
            viewModel.enterTaxSpeciesSpeciesByIdUseCase(taxLayerSpeciesId, it)
        }
        showDialog(dialog, requireContext())
    }

    override fun onCoeffClick(taxLayerSpeciesId: UUID, coeff: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Коэфф.",
            startValue = coeff,
            isNullable = true,
        ) { viewModel.enterTaxSpeciesCoeffByIdUseCase(taxLayerSpeciesId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onAgeClick(taxLayerSpeciesId: UUID, age: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Возраст",
            startValue = age,
            isNullable = true,
        ) { viewModel.enterTaxSpeciesAgeByIdUseCase(taxLayerSpeciesId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onTaxLayerSpeciesHeightClick(taxLayerSpeciesId: UUID, height: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Высоту",
            startValue = height,
            isNullable = true,
        ) { viewModel.enterTaxSpeciesHeightByIdUseCase(taxLayerSpeciesId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onDiameterClick(taxLayerSpeciesId: UUID, diameter: Int?) {
        val dialog = InputIntDialog(
            title = "Введите Диаметр",
            startValue = diameter,
            isNullable = true,
        ) { viewModel.enterTaxSpeciesDiameterByIdUseCase(taxLayerSpeciesId, it) }
        showDialog(dialog, requireContext())
    }

    override fun onDeleteTaxLayerSpeciesClick(taxLayerSpeciesId: UUID) {
        viewModel.deleteTaxSpeciesByIdUseCase(taxLayerSpeciesId)
    }

    override fun onAddTaxLayerClick(taxId: UUID) {
        viewModel.addTaxLayerUseCase()
    }

    override fun onAddTaxLayerSpeciesClick(taxLayerId: UUID) {
        viewModel.addTaxSpeciesByTaxLayerIdUseCase(taxLayerId)
    }
}