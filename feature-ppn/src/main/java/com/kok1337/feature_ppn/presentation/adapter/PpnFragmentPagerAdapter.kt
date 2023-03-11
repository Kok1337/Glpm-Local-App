package com.kok1337.feature_ppn.presentation.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kok1337.feature_ppn.presentation.fragment.PpnFragment
import com.kok1337.feature_ppn_description.presentation.fragment.PpnDescriptionFragment
import com.kok1337.feature_ppn_taxation.presentation.fragment.PpnTaxationFragment

internal class PpnFragmentPagerAdapter(ppnFragment: PpnFragment) :
    FragmentStateAdapter(ppnFragment) {
    var isTaxEnabled: Boolean = false
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = if (isTaxEnabled) 2 else 1

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> PpnDescriptionFragment()
        1 -> PpnTaxationFragment()
        else -> throw IllegalStateException()
    }
}