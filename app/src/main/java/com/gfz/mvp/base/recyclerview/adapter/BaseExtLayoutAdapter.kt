package com.gfz.mvp.base.recyclerview.adapter

import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import kotlin.collections.ArrayList
import com.gfz.mvp.base.recyclerview.adapter.BaseRecyclerViewHolder as BaseRecyclerViewHolder

/**
 *
 * created by gaofengze on 2021/1/27
 */
abstract class BaseExtLayoutAdapter<T>(list: List<T?> = ArrayList())
    : BaseRecyclerViewAdapter<T>(list) {

    private val EMPTY = -1
    private val FOOT = -2
    private val HEAD = -3
    var footerViewBinding: ViewBinding? = null
    var emptyViewBinding: ViewBinding? = null
    var headerViewBinding: ViewBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        val holder = getExtViewHolder(parent, viewType)
        if (isDataViewType(viewType)) {
            setHolderListener(holder)
        }
        return holder
    }

    private fun getExtViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        return when (viewType) {
            EMPTY -> getEmptyViewHolder(emptyViewBinding!!)
            FOOT -> getFooterViewHolder(footerViewBinding!!)
            HEAD -> getHeaderViewHolder(headerViewBinding!!)
            else -> getViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(@NonNull holder: BaseRecyclerViewHolder<T>, position: Int) {
        val dataPosition = getDataPosition(position)
        holder.bindViewHolder(getData(dataPosition), dataPosition)
    }

    override fun getItemCount(): Int {
        if (isHaveEmpty() && getDataItemCount() == 0) return 1
        return if (isHaveFoot() || isHaveHead()) getDataItemCount() + 1 else getDataItemCount()
    }

    override fun getItemViewType(position: Int): Int {
        if (isEmptyView()) return EMPTY
        if (isHeadView(position)) return HEAD
        return if (isFootView(position)) FOOT else getEFItemViewType(getDataPosition(position))
    }

    /**
     * 根据列表中的位置获取数据中的位置
     * 如果是扩展类型则不做处理
     */
    fun getDataPosition(position: Int): Int {
        if (isDataPosition(position) && isHaveHead()) {
            return position - 1
        }
        return position
    }

    fun notifyAllDataChanged() {
        if (isHaveHead()) {
            notifyItemRangeChanged(1, getDataItemCount())
        } else {
            notifyItemRangeChanged(0, getDataItemCount())
        }
    }

    fun notifyDataChanged(dataPosition: Int) {
        if (isHaveHead()) {
            notifyItemChanged(dataPosition + 1)
        } else {
            notifyItemChanged(dataPosition)
        }
    }

    /**
     * 获取数据长度
     */
    fun getDataItemCount(): Int {
        return getData().size
    }

    open fun getEFItemViewType(position: Int): Int {
        return 0
    }

    /**
     * 是否是数据的类型
     */
    protected fun isDataViewType(viewType: Int): Boolean {
        return viewType >= 0
    }

    /**
     * 是否是数据的位置
     */
    fun isDataPosition(adapterPosition: Int): Boolean {
        return !isExtView(adapterPosition)
    }

    /**
     * 是否有足布局
     */
    fun isHaveHead(): Boolean {
        return headerViewBinding != null
    }

    /**
     * 是否有头布局
     */
    fun isHaveFoot(): Boolean {
        return footerViewBinding != null
    }

    /**
     * 是否有空布局
     */
    fun isHaveEmpty(): Boolean {
        return emptyViewBinding != null
    }

    /**
     * 是否是空布局
     */
    fun isEmptyView(): Boolean {
        return isHaveEmpty() && getDataItemCount() == 0
    }

    /**
     * 是否是足布局
     */
    fun isFootView(adapterPosition: Int): Boolean {
        return isHaveFoot() && getDataItemCount() == adapterPosition
    }

    /**
     * 是否是头布局
     */
    fun isHeadView(adapterPosition: Int): Boolean {
        return isHaveHead() && adapterPosition == 0
    }

    fun isExtView(adapterPosition: Int): Boolean {
        return isHeadView(adapterPosition) || isFootView(adapterPosition) || isEmptyView()
    }

    open fun getHeaderViewHolder(binding: ViewBinding): HeaderViewHolder<T> {
        return HeaderViewHolder(binding)
    }

    open fun getFooterViewHolder(binding: ViewBinding): FooterViewHolder<T> {
        return FooterViewHolder(binding)
    }

    open fun getEmptyViewHolder(binding: ViewBinding): EmptyViewHolder<T> {
        return EmptyViewHolder(binding)
    }

    /**
     * 如果是GridLayoutManager布局，空布局需要独占一行
     * 重写该方法时注意处理
     */
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        val manager = recyclerView.layoutManager
        if (manager is GridLayoutManager) {
            manager.spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (isEmptyView() || isFootView(position)) {
                        1
                    } else manager.spanCount
                }
            }
        }
    }

    //针对流式布局
    override fun onViewAttachedToWindow(holder: BaseRecyclerViewHolder<T>) {
        val layoutPosition: Int = holder.layoutPosition
        if (isEmptyView() || isFootView(layoutPosition)) {
            val layoutParams: ViewGroup.LayoutParams = holder.itemView.layoutParams
            if (layoutParams is StaggeredGridLayoutManager.LayoutParams) {
                //占领全部空间;
                layoutParams.isFullSpan = true
            }
        }
    }

    //数据viewholder需要继承的布局
    abstract inner class DataViewHolder<T>(binding: ViewBinding) : BaseRecyclerViewHolder<T>(binding) {
        override fun getHolderPosition(): Int {
            return getDataPosition(super.getHolderPosition())
        }
    }

    //扩展ViewHolder需要继承的布局
    open class ExtViewHolder<T>(binding: ViewBinding) : BaseRecyclerViewHolder<T>(binding) {
        override fun onBindViewHolder(data: T, position: Int) {
        }
    }

    class EmptyViewHolder<T>(binding: ViewBinding) : ExtViewHolder<T>(binding) {

    }

    class FooterViewHolder<T>(binding: ViewBinding) : ExtViewHolder<T>(binding) {

    }

    class HeaderViewHolder<T>(binding: ViewBinding) : ExtViewHolder<T>(binding) {

    }
}