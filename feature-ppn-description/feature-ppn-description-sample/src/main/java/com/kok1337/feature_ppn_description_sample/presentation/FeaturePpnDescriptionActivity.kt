package com.kok1337.feature_ppn_description_sample.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import com.kok1337.feature_ppn_description.api.domain.module.*
import com.kok1337.feature_ppn_description.presentation.fragment.PpnDescriptionFragment
import com.kok1337.feature_ppn_description_sample.R
import com.kok1337.feature_ppn_description_sample.app.App
import com.kok1337.feature_ppn_description_sample.di.DaggerPpnDescriptionActivityComponent
import com.kok1337.feature_ppn_description_sample.di.PpnDescriptionActivityDeps
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class FeaturePpnDescriptionActivity : AppCompatActivity(), HasDependencies {
    private val viewModel: FeaturePpnDescriptionViewModel by viewModels()

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onCreate(savedInstanceState: Bundle?) {
        val ppnDescriptionActivityDeps =
            (applicationContext as App).depsMap[PpnDescriptionActivityDeps::class.java] as PpnDescriptionActivityDeps

        Log.e("FeaturePpnDescriptionActivity", "DaggerPpnDescriptionActivityComponent")
        DaggerPpnDescriptionActivityComponent.factory()
            .create(ppnDescriptionActivityDeps, LocalityInMemoryRepositoryImpl())
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_ppn_description)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, PpnDescriptionFragment())
                .commit()
        }
    }

    inner class LocalityInMemoryRepositoryImpl : LocalityInMemoryRepository {
        override fun getLocalityStateFlow(): StateFlow<Locality> {
            return viewModel.localityStateFlow
        }

        override fun updateRegion(region: Region?) = viewModel.updateRegion(region)

        override fun updateForestry(forestry: Forestry?) = viewModel.updateForestry(forestry)

        override fun updateLocalForestry(localForestry: LocalForestry?) =
            viewModel.updateLocalForestry(localForestry)

        override fun updateSubForestry(subForestry: SubForestry?) =
            viewModel.updateSubForestry(subForestry)

        override fun updateArea(area: String?) = viewModel.updateArea(area)
    }
}