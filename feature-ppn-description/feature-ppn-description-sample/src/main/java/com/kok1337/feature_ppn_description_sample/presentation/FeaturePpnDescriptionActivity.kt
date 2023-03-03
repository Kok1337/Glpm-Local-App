package com.kok1337.feature_ppn_description_sample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kok1337.feature_ppn_description.PpnDescriptionFragment
import com.kok1337.feature_ppn_description_sample.R

class FeaturePpnDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_feature_ppn_description)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, PpnDescriptionFragment())
                .commit()
        }
    }
}