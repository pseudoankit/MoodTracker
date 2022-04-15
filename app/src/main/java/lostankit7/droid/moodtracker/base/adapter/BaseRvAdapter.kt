package lostankit7.droid.moodtracker.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRvAdapter<VB : ViewBinding, T : Any>(
    val mList: MutableList<T> = mutableListOf(),
    val context: Context? = null
) : RecyclerView.Adapter<BaseRvAdapter.Companion.ViewHolder<VB>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
        val binding = inflateLayout(LayoutInflater.from(parent.context), parent, false)
        onCreateViewHolder(binding)
        return ViewHolder(binding)
    }

    open fun onCreateViewHolder(binding: VB) {}


    override fun onBindViewHolder(holder: ViewHolder<VB>, position: Int) {
        bindViewHolder(mList[position], position, holder.binding)
    }

    override fun getItemCount() = mList.size

    abstract fun bindViewHolder(item: T, position: Int, binding: VB)
    abstract fun inflateLayout(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): VB

    companion object {
        class ViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
    }
}