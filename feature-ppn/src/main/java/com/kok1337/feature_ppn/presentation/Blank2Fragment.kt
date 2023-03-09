package com.kok1337.feature_ppn.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kok1337.feature_ppn.R

class Blank2Fragment : Fragment(R.layout.fragment_blank2) {
    private lateinit var viewModel: Blank2ViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[Blank2ViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Blank2Fragment", "onViewCreated жесть")
    }
}