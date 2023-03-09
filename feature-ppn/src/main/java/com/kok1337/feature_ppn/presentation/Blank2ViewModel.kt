package com.kok1337.feature_ppn.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class Blank2ViewModel : ViewModel() {
    init {
        Log.e("Blank2ViewModel", "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("Blank2ViewModel", "onCleared")
    }
}