package com.kok1337.feature_ppn.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kok1337.feature_ppn.presentation.Blank1Fragment
import com.kok1337.feature_ppn.presentation.Blank2Fragment
import com.kok1337.feature_ppn.presentation.fragment.PpnFragment
import com.kok1337.feature_ppn_description.presentation.fragment.PpnDescriptionFragment

internal class PpnFragmentPagerAdapter(ppnFragment: PpnFragment) :
    FragmentStateAdapter(ppnFragment) {
    var isTaxEnabled: Boolean = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = if (isTaxEnabled) 2 else 1

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> PpnDescriptionFragment()
        1 -> Blank2Fragment()
        else -> throw IllegalStateException()
    }
}