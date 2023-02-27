package com.kok1337.searchable_spinner.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kok1337.common_diff_callback.CommonCallbackImpl

abstract class SearchableSpinnerBindingAdapter<T, B : ViewDataBinding>(
    private val layoutId: Int,
) : RecyclerView.Adapter<SearchableSpinnerBindingAdapter.BindingViewHolder<B>>() {
    class BindingViewHolder<BH : ViewDataBinding>(val binding: BH) :
        RecyclerView.ViewHolder(binding.root)

    var onItemClicked: OnItemClicked<T>? = null

    var items: List<T> = emptyList()
        set(value) {
            val callback = CommonCallbackImpl(
                oldItems = field,
                newItems = value,
                areContentsTheSameImpl = ::areContentsTheSame,
                areItemsTheSameImpl = ::areItemsTheSame,
            )
            field = value
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    protected fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    protected fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<B>(inflater, layoutId, parent, false)
        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int) {
        val item: T = items[position]
        val binding: B = holder.binding
        binding.root.setOnClickListener {
            onItemClicked?.invoke(item)
        }
        setupView(binding, item, position)
    }

    abstract fun setupView(binding: B, item: T, position: Int)
}