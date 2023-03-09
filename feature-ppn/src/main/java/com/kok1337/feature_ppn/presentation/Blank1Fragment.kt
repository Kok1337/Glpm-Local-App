package com.kok1337.feature_ppn.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kok1337.feature_ppn.R

class Blank1Fragment : Fragment(R.layout.fragment_blank1) {
    private lateinit var viewModel: Blank1ViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this)[Blank1ViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Blank1Fragment", "onViewCreated")
    }
}