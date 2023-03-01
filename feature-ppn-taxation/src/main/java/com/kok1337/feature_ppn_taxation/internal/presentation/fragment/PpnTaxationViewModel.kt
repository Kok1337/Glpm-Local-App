package com.kok1337.feature_ppn_taxation.internal.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.feature_ppn_taxation.api.dependencies.*
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.ItemTransformer
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.species.api.model.Species
import com.kok1337.tax.api.model.Tax
import com.kok1337.unforested_land.api.model.UnforestedLand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

internal class PpnTaxationViewModel(
    private val taxFlow: StateFlow<Tax>,
    private val landSelector: LandSelector,
    private val taxRedactor: TaxRedactor,
    private val taxSelector: TaxSelector,
    private val taxLayerRedactor: TaxLayerRedactor,
    private val taxLayerSelector: TaxLayerSelector,
    private val taxLayerSpeciesRedactor: TaxLayerSpeciesRedactor,
    private val taxLayerSpeciesSelector: TaxLayerSpeciesSelector,
) : ViewModel(), AdapterListener {
    private val _isCoveredForestFlow =
        MutableStateFlow(isCoveredForestByTax(taxFlow.value))
    private val _landFlow = MutableStateFlow<Land?>(null)

    val listItemListFlow: Flow<List<ListItem>> = combineTransform(
        _isCoveredForestFlow, taxFlow, _landFlow
    ) { isCoveredForest, tax, land ->
        emit(ItemTransformer.transformToListItemList(tax, isCoveredForest, land))
    }

    private fun isCoveredForestByTax(tax: Tax): Boolean {
        if (tax.unforestedLand == null && tax.nonForestLand == null) return false
        return true
    }

    override fun onNotCoveredForestClick(isCovered: Boolean) {
        _isCoveredForestFlow.value = isCovered
    }

    override fun onLandClick(land: Land?) {
        viewModelScope.launch(Dispatchers.IO) {
            landSelector.selectLand(land) {
                _landFlow.value = it
            }
        }
    }

    override fun onUnforestedLandClick(unforestedLand: UnforestedLand?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectUnforestedLand(unforestedLand) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateUnforestedLand(it)
                }
            }
        }
    }

    override fun onNonForestLandClick(nonForestLand: NonForestLand?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectNonForestLand(nonForestLand) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateNonForestLand(it)
                }
            }
        }
    }

    override fun onForestPurposeClick(forestPurpose: ForestPurpose?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectForestPurpose(forestPurpose) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateForestPurpose(it)
                }
            }
        }
    }

    override fun onProtectionCategoryClick(protectionCategory: ProtectionCategory?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectProtectionCategory(protectionCategory) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateProtectionCategory(it)
                }
            }
        }
    }

    override fun onBonitetClick(bonitet: Bonitet?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectBonitet(bonitet) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateBonitet(it)
                }
            }
        }
    }

    override fun onForestTypeClick(forestType: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectForestType(forestType) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateForestType(it)
                }
            }
        }
    }

    override fun onOzuClick(ozu: Ozu?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxSelector.selectOzu(ozu) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxRedactor.updateOzu(it)
                }
            }
        }
    }

    override fun onTaxLayerHeightClick(taxLayerId: UUID, height: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSelector.selectHeight(height) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerRedactor.updateHeight(taxLayerId, it)
                }
            }
        }
    }

    override fun onAgeClassClick(taxLayerId: UUID, ageClass: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSelector.selectAgeClass(ageClass) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerRedactor.updateAgeClass(taxLayerId, it)
                }
            }
        }
    }

    override fun onAgeGroupClick(taxLayerId: UUID, ageGroup: AgeGroup?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSelector.selectAgeGroup(ageGroup) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerRedactor.updateAgeGroup(taxLayerId, it)
                }
            }
        }
    }

    override fun onFullnessClick(taxLayerId: UUID, fullness: Double?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSelector.selectFullness(fullness) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerRedactor.updateFullness(taxLayerId, it)
                }
            }
        }
    }

    override fun onStockClick(taxLayerId: UUID, stock: Double?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSelector.selectStock(stock) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerRedactor.updateStock(taxLayerId, it)
                }
            }
        }
    }

    override fun onDeleteTaxLayerClick(taxLayerId: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerRedactor.deleteTaxLayer(taxLayerId)
        }
    }

    override fun onSpeciesClick(taxLayerSpeciesId: UUID, species: Species?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesSelector.selectSpecies(species) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerSpeciesRedactor.updateSpecies(taxLayerSpeciesId, it)
                }
            }
        }
    }

    override fun onCoeffClick(taxLayerSpeciesId: UUID, coeff: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesSelector.selectCoeff(coeff) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerSpeciesRedactor.updateCoeff(taxLayerSpeciesId, it)
                }
            }
        }
    }

    override fun onAgeClick(taxLayerSpeciesId: UUID, age: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesSelector.selectAge(age) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerSpeciesRedactor.updateAge(taxLayerSpeciesId, it)
                }
            }
        }
    }

    override fun onTaxLayerSpeciesHeightClick(taxLayerSpeciesId: UUID, height: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesSelector.selectHeight(height) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerSpeciesRedactor.updateHeight(taxLayerSpeciesId, it)
                }
            }
        }
    }

    override fun onDiameterClick(taxLayerSpeciesId: UUID, diameter: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesSelector.selectDiameter(diameter) {
                viewModelScope.launch(Dispatchers.IO) {
                    taxLayerSpeciesRedactor.updateDiameter(taxLayerSpeciesId, it)
                }
            }
        }
    }

    override fun onDeleteTaxLayerSpeciesClick(taxLayerSpeciesId: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerSpeciesRedactor.deleteTaxLayerSpecies(taxLayerSpeciesId)
        }
    }

    override fun onAddTaxLayerClick(taxId: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.addTaxLayer()
        }
    }

    override fun onAddTaxLayerSpeciesClick(taxLayerId: UUID) {
        viewModelScope.launch(Dispatchers.IO) {
            taxLayerRedactor.addTaxLayerSpecies(taxLayerId)
        }
    }

    class Factory @Inject constructor(
        private val taxStateFlowProvider: TaxStateFlowProvider,
        private val redactorProvider: RedactorProvider,
        private val selectorProvider: SelectorProvider,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnTaxationViewModel::class.java)
            return PpnTaxationViewModel(
                taxFlow = taxStateFlowProvider.get(),
                taxLayerRedactor = redactorProvider.getTaxLayerRedactor(),
                taxLayerSelector = selectorProvider.getTaxLayerSelector(),
                taxLayerSpeciesRedactor = redactorProvider.getTaxLayerSpeciesRedactor(),
                taxLayerSpeciesSelector = selectorProvider.getTaxLayerSpeciesSelector(),
                taxRedactor = redactorProvider.getTaxRedactor(),
                taxSelector = selectorProvider.getTaxSelector(),
                landSelector = selectorProvider.getLandSelector(),
            ) as T
        }
    }
}