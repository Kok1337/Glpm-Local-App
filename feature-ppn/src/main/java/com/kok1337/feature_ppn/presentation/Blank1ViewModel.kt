package com.kok1337.feature_ppn.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class Blank1ViewModel : ViewModel() {
    init {
        Log.e("Blank1ViewModel", "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("Blank1ViewModel", "onCleared")
    }
}