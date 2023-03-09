package com.kok1337.feature_ppn_sample.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kok1337.feature_ppn.presentation.fragment.PpnFragment
import com.kok1337.feature_ppn_sample.R

class FeaturePpnSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_ppn_sample)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.sample_container, PpnFragment())
                .commit()
        }
    }
}