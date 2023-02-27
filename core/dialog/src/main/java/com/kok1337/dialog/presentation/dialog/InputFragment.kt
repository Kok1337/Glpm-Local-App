package com.kok1337.dialog.presentation.dialog

import android.os.Bundle
import android.text.InputType
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.app_listeners.AppTextWatcher
import com.kok1337.dialog.R
import com.kok1337.dialog.databinding.DialogInputBinding

private enum class Input(val inputType: Int) {
    TEXT(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE),
    INT(InputType.TYPE_CLASS_NUMBER),
    DOUBLE(InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL),
}

sealed class InputDialog<T>(
    private val title: String,
    private val startValue: T? = null,
    private val isNullable: Boolean = true,
    private val input: Input = Input.TEXT,
    private val valueChecker: ((T) -> Boolean)? = null,
    private val onValueIntroduced: (T?) -> Unit
) : DialogFragment(R.layout.dialog_input) {
    private val binding by viewBinding(DialogInputBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTextView.text = title
        binding.acceptButton.isEnabled = (isNullable && startValue == null)
        binding.editText.inputType = input.inputType
        binding.editText.setText(startValue?.toString() ?: "")
        binding.editText.addTextChangedListener(AppTextWatcher { it?.let { onTextChanged(it) } })
        binding.editText.requestFocus()
        binding.acceptButton.setOnClickListener { confirm() }
        binding.cancelButton.setOnClickListener { closeDialog() }
    }

    abstract fun castInput(inputText: String): T?

    private fun onTextChanged(inputText: String) {
        if (inputText.isEmpty() && isNullable) {
            binding.acceptButton.isEnabled = true
            return
        }

        val value: T? = castInput(inputText)
        if (value == null) {
            binding.acceptButton.isEnabled = false
            return
        }
        if (valueChecker == null) {
            binding.acceptButton.isEnabled = true
            return
        }
        binding.acceptButton.isEnabled = valueChecker.invoke(value)
    }

    private fun confirm() {
        val inputText = binding.editText.text.toString()
        val value = if (inputText.isEmpty() && isNullable) null else castInput(inputText)
        onValueIntroduced.invoke(value)
        closeDialog()
    }

    private fun closeDialog() {
        dismiss()
    }
}

class InputStringDialog(
    title: String,
    startValue: String? = null,
    isNullable: Boolean = true,
    valueChecker: ((String) -> Boolean)? = null,
    onValueIntroduced: (String?) -> Unit
) : InputDialog<String>(
    title, startValue, isNullable, Input.TEXT, valueChecker, onValueIntroduced
) {
    override fun castInput(inputText: String): String {
        return inputText
    }
}

class InputIntDialog(
    title: String,
    startValue: Int? = null,
    isNullable: Boolean = true,
    valueChecker: ((Int) -> Boolean)? = null,
    onValueIntroduced: (Int?) -> Unit
) : InputDialog<Int>(
    title, startValue, isNullable, Input.INT, valueChecker, onValueIntroduced
) {
    override fun castInput(inputText: String): Int? {
        return inputText.toIntOrNull()
    }
}

class InputDoubleDialog(
    title: String,
    startValue: Double? = null,
    isNullable: Boolean = true,
    valueChecker: ((Double) -> Boolean)? = null,
    onValueIntroduced: (Double?) -> Unit
) : InputDialog<Double>(
    title, startValue, isNullable, Input.DOUBLE, valueChecker, onValueIntroduced
) {
    override fun castInput(inputText: String): Double? {
        return inputText.toDoubleOrNull()
    }
}