package com.kok1337.feature_ppn_description_sample.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.*
import com.kok1337.feature_ppn_description.api.presentation.fragment.PpnDescriptionFragment
import com.kok1337.feature_ppn_description_sample.R
import com.kok1337.feature_ppn_description_sample.app.App
import com.kok1337.feature_ppn_description_sample.di.DaggerPpnDescriptionActivityComponent
import com.kok1337.feature_ppn_description_sample.di.PpnDescriptionActivityDeps
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeaturePpnDescriptionActivity : AppCompatActivity(), HasDependencies {
    private val viewModel: FeaturePpnDescriptionViewModel by viewModels()

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_ppn_description)

        val ppnDescriptionActivityDeps =
            (applicationContext as App).depsMap[PpnDescriptionActivityDeps::class.java] as PpnDescriptionActivityDeps

        DaggerPpnDescriptionActivityComponent.factory()
            .create(ppnDescriptionActivityDeps, AddressInMemoryRepositoryImpl())
            .inject(this)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, PpnDescriptionFragment())
                .commit()
        }
    }

    inner class AddressInMemoryRepositoryImpl() : AddressInMemoryRepository {
        override fun getAddressFlow(): Flow<Address> {
            return viewModel.addressFlow
        }

        override fun updateRegion(region: Region?) {
        }

        override fun updateForestry(forestry: Forestry?) {
        }

        override fun updateLocalForestry(localForestry: LocalForestry?) {
        }

        override fun updateSubForestry(subForestry: SubForestry?) {
        }

        override fun updateArea(area: String?) {
        }
    }
}