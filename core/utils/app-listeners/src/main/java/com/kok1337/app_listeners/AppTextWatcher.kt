package com.kok1337.app_listeners

import android.text.Editable
import android.text.TextWatcher

class AppTextWatcher(val onSuccess: (String?) -> Unit) : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onSuccess(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {}
}