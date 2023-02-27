package com.kok1337.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun unwrapAppCompatActivity(context: Context): AppCompatActivity {
    if (context !is Activity && context is ContextWrapper)
        return unwrapAppCompatActivity(context.baseContext)
    return context as AppCompatActivity
}

fun showDialog(dialog: DialogFragment, context: Context) {
    dialog.show(
        unwrapAppCompatActivity(context).supportFragmentManager,
        dialog::class.simpleName ?: "TAG"
    )
}