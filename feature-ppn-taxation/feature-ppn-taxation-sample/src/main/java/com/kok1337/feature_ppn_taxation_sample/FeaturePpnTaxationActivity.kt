package com.kok1337.feature_ppn_taxation_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.database.api.JdbcTemplateDatasourceProvider
import com.kok1337.database.api.JdbcTemplateDependencies
import com.kok1337.database.api.JdbcTemplateFactory
import com.kok1337.feature_ppn_taxation.api.dependencies.*
import com.kok1337.feature_ppn_taxation.api.fragment.PpnTaxationFragment
import com.kok1337.feature_ppn_taxation_sample.di.DaggerFeaturePpnTaxationActivityComponent
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import com.kok1337.species.api.model.Species
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import com.kok1337.unforested_land.api.model.UnforestedLand
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.*
import javax.inject.Inject

class FeaturePpnTaxationActivity : AppCompatActivity(), HasDependencies {
    @Inject
    override lateinit var depsMap: DepsMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jdbcTemplateDependencies = object : JdbcTemplateDependencies {
            override val jdbcTemplateDatasourceProvider: JdbcTemplateDatasourceProvider
                get() = object : JdbcTemplateDatasourceProvider {
                    override val host: String get() = "127.0.0.1"
                    override val port: String get() = "5432"
                    override val name: String get() = "glpm_local"
                    override val username: String get() = "postgres"
                    override val password: String get() = "postgres"
                    override val driverName: String get() = "org.postgresql.Driver"
                }
        }
        val jdbcTemplate = JdbcTemplateFactory.create(jdbcTemplateDependencies)
        val taxStateFlowProvider = object : TaxStateFlowProvider {
            override fun get(): StateFlow<Tax> = _taxFlow.asStateFlow()
        }
        val taxRedactorProvider = object : RedactorProvider {
            override fun getTaxRedactor(): TaxRedactor =
                _taxTaxRedactor

            override fun getTaxLayerRedactor(): TaxLayerRedactor =
                _taxTaxLayerRedactor

            override fun getTaxLayerSpeciesRedactor(): TaxLayerSpeciesRedactor =
                _taxTaxLayerSpeciesRedactor
        }

        DaggerFeaturePpnTaxationActivityComponent.factory()
            .create(jdbcTemplate, taxRedactorProvider, taxStateFlowProvider)
            .inject(this)

        setContentView(R.layout.activity_feature_ppn_taxation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, PpnTaxationFragment())
                .commit()
        }
    }

    private val _taxFlow = MutableStateFlow(initTax())

    private fun initTax(): Tax {
        val taxId = UUID.randomUUID()
        val taxLayerList = listOf(
            TaxLayer(id = UUID.randomUUID(), parentId = taxId, taxLayerSpeciesList = emptyList()),
            TaxLayer(id = UUID.randomUUID(), parentId = taxId, taxLayerSpeciesList = emptyList()),
            TaxLayer(id = UUID.randomUUID(), parentId = taxId, taxLayerSpeciesList = emptyList())
        )
        return Tax(
            id = taxId,
            localityId = UUID.randomUUID(),
            section = "Section",
            taxLayerList = taxLayerList
        )
    }

    private val _taxTaxRedactor = object : TaxRedactor {
        override suspend fun updateUnforestedLand(unforestedLand: UnforestedLand?) {
            _taxFlow.update { it.copy(unforestedLand = unforestedLand) }
        }

        override suspend fun updateNonForestLand(nonForestLand: NonForestLand?) {
            _taxFlow.update { it.copy(nonForestLand = nonForestLand) }
        }

        override suspend fun updateForestPurpose(forestPurpose: ForestPurpose?) {
            _taxFlow.update {
                if (forestPurpose == it.forestPurpose) return
                it.copy(forestPurpose = forestPurpose, protectionCategory = null)
            }
        }

        override suspend fun updateProtectionCategory(protectionCategory: ProtectionCategory?) {
            _taxFlow.update { it.copy(protectionCategory = protectionCategory) }
        }

        override suspend fun updateBonitet(bonitet: Bonitet) {
            _taxFlow.update { it.copy(bonitet = bonitet) }
        }

        override suspend fun updateForestType(forestType: String?) {
            _taxFlow.update { it.copy(forestType = forestType) }
        }

        override suspend fun updateOzu(ozu: Ozu?) {
            _taxFlow.update { it.copy(ozu = ozu) }
        }

        override suspend fun addTaxLayer() {
            _taxFlow.update {
                val id = UUID.randomUUID()
                val parentId = it.id
                val taxLayerSpeciesList = emptyList<TaxLayerSpecies>()
                val newTaxLayer = TaxLayer(
                    id = id,
                    parentId = parentId,
                    taxLayerSpeciesList = taxLayerSpeciesList
                )
                val taxLayerList = it.taxLayerList + newTaxLayer
                it.copy(taxLayerList = taxLayerList)
            }
        }
    }

    private val _taxTaxLayerRedactor = object : TaxLayerRedactor {
        fun updateTaxLayer(taxLayerId: UUID, transformation: (TaxLayer) -> TaxLayer) {
            val tax = _taxFlow.value
            val taxLayer = tax.taxLayerList.first { taxLayer -> taxLayer.id == taxLayerId }
            val updatedTaxLayer = transformation(taxLayer)
            val taxLayerList = ArrayList(tax.taxLayerList)
            val updateIndex = taxLayerList.indexOf(taxLayer)
            taxLayerList[updateIndex] = updatedTaxLayer
            _taxFlow.update { tax.copy(taxLayerList = taxLayerList) }
        }

        override suspend fun updateHeight(taxLayerId: UUID, height: Int?) {
            updateTaxLayer(taxLayerId) { it.copy(height = height) }
        }

        override suspend fun updateAgeClass(taxLayerId: UUID, ageClass: Int?) {
            updateTaxLayer(taxLayerId) { it.copy(ageClass = ageClass) }
        }

        override suspend fun updateAgeGroup(taxLayerId: UUID, ageGroup: AgeGroup?) {
            updateTaxLayer(taxLayerId) { it.copy(ageGroup = ageGroup) }
        }

        override suspend fun updateFullness(taxLayerId: UUID, fullness: Double?) {
            updateTaxLayer(taxLayerId) { it.copy(fullness = fullness) }
        }

        override suspend fun updateStock(taxLayerId: UUID, stock: Double?) {
            updateTaxLayer(taxLayerId) { it.copy(stock = stock) }
        }

        override suspend fun addTaxLayerSpecies(taxLayerId: UUID) {
            val id = UUID.randomUUID()
            val newTaxLayerSpecies = TaxLayerSpecies(id = id, parentId = taxLayerId)
            updateTaxLayer(taxLayerId) { taxLayer ->
                val taxLayerSpeciesList =
                    ArrayList(taxLayer.taxLayerSpeciesList) + newTaxLayerSpecies
                taxLayer.copy(taxLayerSpeciesList = taxLayerSpeciesList)
            }
        }

        override suspend fun deleteTaxLayer(taxLayerId: UUID) {
            updateTaxLayer(taxLayerId) { taxLayer ->
                val taxLayerSpeciesList = ArrayList(taxLayer.taxLayerSpeciesList)
                val removeIndex = taxLayerSpeciesList.indexOfFirst { it.id == taxLayerId }
                taxLayerSpeciesList.removeAt(removeIndex)
                taxLayer.copy(taxLayerSpeciesList = taxLayerSpeciesList)
            }
        }
    }

    private val _taxTaxLayerSpeciesRedactor = object : TaxLayerSpeciesRedactor {
        private fun getTaxLayerByTaxLayerSpeciesId(taxLayerSpeciesId: UUID): TaxLayer {
            val tax = _taxFlow.value
            val taxLayer = tax.taxLayerList.first { taxLayer ->
                taxLayer.taxLayerSpeciesList.any { taxLayerSpecies -> taxLayerSpecies.id == taxLayerSpeciesId }
            }
            return taxLayer
        }

        fun updateTaxLayer(taxLayerId: UUID, transformation: (TaxLayer) -> TaxLayer) {
            val tax = _taxFlow.value
            val taxLayer = tax.taxLayerList.first { taxLayer -> taxLayer.id == taxLayerId }
            val updatedTaxLayer = transformation(taxLayer)
            val taxLayerList = ArrayList(tax.taxLayerList)
            val updateIndex = taxLayerList.indexOf(taxLayer)
            taxLayerList[updateIndex] = updatedTaxLayer
            _taxFlow.update { tax.copy(taxLayerList = taxLayerList) }
        }

        private fun updateTaxLayerSpecies(
            taxLayerSpeciesId: UUID,
            transformation: (TaxLayerSpecies) -> TaxLayerSpecies
        ) {
            val taxLayer = getTaxLayerByTaxLayerSpeciesId(taxLayerSpeciesId)
            updateTaxLayer(taxLayer.id) {
                val taxLayerSpeciesList = ArrayList(taxLayer.taxLayerSpeciesList)
                val updateIndex =
                    taxLayerSpeciesList.indexOfFirst { taxLayerSpecies -> taxLayerSpecies.id == taxLayerSpeciesId }
                val taxLayerSpecies = taxLayerSpeciesList[updateIndex]
                val updatedTaxLayerSpecies = transformation(taxLayerSpecies)
                taxLayerSpeciesList[updateIndex] = updatedTaxLayerSpecies
                it.copy(taxLayerSpeciesList = taxLayerSpeciesList)
            }
        }

        override suspend fun updateCoeff(taxLayerSpeciesId: UUID, coeff: Int?) {
            updateTaxLayerSpecies(taxLayerSpeciesId) { it.copy(coeff = coeff) }
        }

        override suspend fun updateSpecies(taxLayerSpeciesId: UUID, species: Species?) {
            updateTaxLayerSpecies(taxLayerSpeciesId) { it.copy(species = species) }
        }

        override suspend fun updateAge(taxLayerSpeciesId: UUID, age: Int?) {
            updateTaxLayerSpecies(taxLayerSpeciesId) { it.copy(age = age) }
        }

        override suspend fun updateHeight(taxLayerSpeciesId: UUID, height: Int?) {
            updateTaxLayerSpecies(taxLayerSpeciesId) { it.copy(height = height) }
        }

        override suspend fun updateDiameter(taxLayerSpeciesId: UUID, diameter: Int?) {
            updateTaxLayerSpecies(taxLayerSpeciesId) { it.copy(diameter = diameter) }
        }

        override suspend fun deleteTaxLayerSpecies(taxLayerSpeciesId: UUID) {
            val taxLayer = getTaxLayerByTaxLayerSpeciesId(taxLayerSpeciesId)
            updateTaxLayer(taxLayer.id) {
                val taxLayerSpeciesList = ArrayList(taxLayer.taxLayerSpeciesList)
                val removeIndex = taxLayerSpeciesList.indexOfFirst { it.id == taxLayerSpeciesId }
                taxLayerSpeciesList.removeAt(removeIndex)
                it.copy(taxLayerSpeciesList = taxLayerSpeciesList)
            }
        }
    }
}