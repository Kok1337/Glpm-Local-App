package com.kok1337.feature_ppn.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn.domain.use_case.GetLocalityWithIdUseCase
import com.kok1337.feature_ppn.domain.use_case.GetTaxByIdUseCase
import com.kok1337.species.domain.model.Species
import com.kok1337.taxation.domain.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

internal class PpnViewModel(
    private val getLocalityWithIdUseCase: GetLocalityWithIdUseCase,
    private val getTaxByIdUseCase: GetTaxByIdUseCase,
) : ViewModel() {
    private val _localityStateFlow =
        MutableStateFlow(Locality(federalDistrict = FederalDistrict(5, "")))
    val localityStateFlow = _localityStateFlow.asStateFlow()
    private val _taxStateFlow = MutableStateFlow<Tax?>(null)
    val taxStateFlow = _taxStateFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            localityStateFlow.collect { locality ->
                if (locality.id == null) _taxStateFlow.value = null
            }
        }
    }

    fun updateRegion(region: Region?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.region == region) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = region,
        )
        _localityStateFlow.value = newLocality
    }

    fun updateForestry(forestry: Forestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.forestry == forestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = forestry
        )
        _localityStateFlow.value = newLocality
    }

    fun updateLocalForestry(localForestry: LocalForestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.localForestry == localForestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = localForestry
        )
        _localityStateFlow.value = newLocality
    }

    fun updateSubForestry(subForestry: SubForestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.subForestry == subForestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = currentLocality.localForestry,
            subForestry = subForestry,
        )
        _localityStateFlow.value = newLocality
    }

    fun updateArea(area: String?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.area == area) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = currentLocality.localForestry,
            subForestry = currentLocality.subForestry,
            area = area,
        )
        _localityStateFlow.value = newLocality
        getLocalityWithId()
    }

    private fun getLocalityWithId() = viewModelScope.launch(Dispatchers.IO) {
        _localityStateFlow.update {
            getLocalityWithIdUseCase(it)
        }
    }

    fun getTaxById(id: UUID) = viewModelScope.launch(Dispatchers.IO) {
        _taxStateFlow.value = getTaxByIdUseCase(id)
    }

    fun addTaxLayer() {
        val tax = _taxStateFlow.value ?: return
        val id = UUID.randomUUID()
        val parentId = tax.id
        val taxLayerSpeciesList = emptyList<TaxSpecies>()
        val newTaxLayer = TaxLayer(
            id = id, parentId = parentId, taxSpeciesList = taxLayerSpeciesList
        )
        val taxLayerList = tax.taxLayerList + newTaxLayer
        _taxStateFlow.value = tax.copy(taxLayerList = taxLayerList)
    }

    private fun updateTaxLayerById(taxLayerId: UUID, transformation: (TaxLayer) -> TaxLayer) {
        val tax = _taxStateFlow.value ?: return
        val taxLayer = tax.taxLayerList.first { taxLayer -> taxLayer.id == taxLayerId }
        val updatedTaxLayer = transformation(taxLayer)
        val taxLayerList = ArrayList(tax.taxLayerList)
        val updateIndex = taxLayerList.indexOf(taxLayer)
        taxLayerList[updateIndex] = updatedTaxLayer
        _taxStateFlow.update { tax.copy(taxLayerList = taxLayerList) }
    }

    fun deleteTaxLayerById(taxLayerId: UUID) {
        val tax = _taxStateFlow.value ?: return
        val taxLayerList = ArrayList(tax.taxLayerList)
        val deleteIndex = taxLayerList.indexOfFirst { taxLayer -> taxLayer.id == taxLayerId }
        taxLayerList.removeAt(deleteIndex)
        _taxStateFlow.value = tax.copy(taxLayerList = taxLayerList)
    }

    fun addTaxSpeciesByTaxLayerId(taxLayerId: UUID) {
        val id = UUID.randomUUID()
        val newTaxLayerSpecies = TaxSpecies(id = id, parentId = taxLayerId)
        updateTaxLayerById(taxLayerId) { taxLayer ->
            val taxLayerSpeciesList = ArrayList(taxLayer.taxSpeciesList) + newTaxLayerSpecies
            taxLayer.copy(taxSpeciesList = taxLayerSpeciesList)
        }
    }

    fun updateTaxUnforestedLand(unforestedLand: UnforestedLand?) {
        _taxStateFlow.update { it!!.copy(unforestedLand = unforestedLand, nonForestLand = null) }
    }

    fun updateTaxNonForestLand(nonForestLand: NonForestLand?) {
        _taxStateFlow.update { it!!.copy(nonForestLand = nonForestLand, unforestedLand = null) }
    }

    fun updateTaxForestPurpose(forestPurpose: ForestPurpose?) {
        _taxStateFlow.update {
            if (forestPurpose == it!!.forestPurpose) return
            it.copy(forestPurpose = forestPurpose, protectionCategory = null)
        }
    }

    fun updateTaxProtectionCategory(protectionCategory: ProtectionCategory?) {
        _taxStateFlow.update { it!!.copy(protectionCategory = protectionCategory) }
    }

    fun updateTaxBonitet(bonitet: Bonitet?) {
        _taxStateFlow.update { it!!.copy(bonitet = bonitet) }
    }

    fun updateTaxForestType(forestType: String?) {
        _taxStateFlow.update { it!!.copy(forestType = forestType) }
    }

    fun updateTaxOzu(ozu: Ozu?) {
        _taxStateFlow.update { it!!.copy(ozu = ozu) }
    }

    private fun getTaxLayerByTaxSpeciesId(taxSpeciesId: UUID): TaxLayer {
        val tax = _taxStateFlow.value!!
        val taxLayer = tax.taxLayerList.first { taxLayer ->
            taxLayer.taxSpeciesList.any { taxSpecies -> taxSpecies.id == taxSpeciesId }
        }
        return taxLayer
    }

    private fun updateTaxSpeciesById(
        taxLayerSpeciesId: UUID, transformation: (TaxSpecies) -> TaxSpecies
    ) {
        val taxLayer = getTaxLayerByTaxSpeciesId(taxLayerSpeciesId)
        updateTaxLayerById(taxLayer.id) {
            val taxLayerSpeciesList = ArrayList(taxLayer.taxSpeciesList)
            val updateIndex =
                taxLayerSpeciesList.indexOfFirst { taxLayerSpecies -> taxLayerSpecies.id == taxLayerSpeciesId }
            val taxLayerSpecies = taxLayerSpeciesList[updateIndex]
            val updatedTaxLayerSpecies = transformation(taxLayerSpecies)
            taxLayerSpeciesList[updateIndex] = updatedTaxLayerSpecies
            it.copy(taxSpeciesList = taxLayerSpeciesList)
        }
    }

    fun deleteTaxSpeciesById(taxLayerSpeciesId: UUID) {
        val taxLayer = getTaxLayerByTaxSpeciesId(taxLayerSpeciesId)
        updateTaxLayerById(taxLayer.id) {
            val taxLayerSpeciesList = ArrayList(taxLayer.taxSpeciesList)
            val removeIndex = taxLayerSpeciesList.indexOfFirst { it.id == taxLayerSpeciesId }
            taxLayerSpeciesList.removeAt(removeIndex)
            it.copy(taxSpeciesList = taxLayerSpeciesList)
        }
    }

    fun updateTaxSpeciesCoeff(taxLayerSpeciesId: UUID, coeff: Int?) {
        updateTaxSpeciesById(taxLayerSpeciesId) { it.copy(coeff = coeff) }
    }

    fun updateTaxSpeciesSpecies(taxLayerSpeciesId: UUID, species: Species?) {
        updateTaxSpeciesById(taxLayerSpeciesId) { it.copy(species = species) }
    }

    fun updateTaxSpeciesAge(taxLayerSpeciesId: UUID, age: Int?) {
        updateTaxSpeciesById(taxLayerSpeciesId) { it.copy(age = age) }
    }

    fun updateTaxSpeciesHeight(taxLayerSpeciesId: UUID, height: Int?) {
        updateTaxSpeciesById(taxLayerSpeciesId) { it.copy(height = height) }
    }

    fun updateTaxSpeciesDiameter(taxLayerSpeciesId: UUID, diameter: Int?) {
        updateTaxSpeciesById(taxLayerSpeciesId) { it.copy(diameter = diameter) }
    }

    fun updateTaxLayerHeight(taxLayerId: UUID, height: Int?) {
        updateTaxLayerById(taxLayerId) { it.copy(height = height) }
    }

    fun updateTaxLayerAgeClass(taxLayerId: UUID, ageClass: Int?) {
        updateTaxLayerById(taxLayerId) { it.copy(ageClass = ageClass) }
    }

    fun updateTaxLayerAgeGroup(taxLayerId: UUID, ageGroup: AgeGroup?) {
        updateTaxLayerById(taxLayerId) { it.copy(ageGroup = ageGroup) }
    }

    fun updateTaxLayerFullness(taxLayerId: UUID, fullness: Double?) {
        updateTaxLayerById(taxLayerId) { it.copy(fullness = fullness) }
    }

    fun updateTaxLayerStock(taxLayerId: UUID, stock: Double?) {
        updateTaxLayerById(taxLayerId) { it.copy(stock = stock) }
    }

    class Factory @Inject constructor(
        private val getLocalityWithIdUseCase: GetLocalityWithIdUseCase,
        private val getTaxByIdUseCase: GetTaxByIdUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnViewModel::class.java)
            return PpnViewModel(
                getLocalityWithIdUseCase = getLocalityWithIdUseCase,
                getTaxByIdUseCase = getTaxByIdUseCase,
            ) as T
        }
    }
}