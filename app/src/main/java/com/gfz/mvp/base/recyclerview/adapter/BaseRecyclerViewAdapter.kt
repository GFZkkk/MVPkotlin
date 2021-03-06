package com.gfz.mvp.base.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.gfz.mvp.callback.OnItemClickListener
import com.gfz.mvp.data.KTApp
import com.gfz.mvp.utils.TimeCell


/**
 * RecyclerView的adapter的基类
 * created by gaofengze on 2020-01-19
 */

abstract class BaseRecyclerViewAdapter<T>(dataList: List<T?> = ArrayList()) :
    RecyclerView.Adapter<BaseRecyclerViewHolder<T>>() {

    /**
     * 主要数据
     */
    private val list: MutableList<T?> = ArrayList()
    /**
     * 获取数据长度
     */
    protected val length
        get() = list.size
    /**
     * 当前点击的position
     */
    private var clickIndex: Int = -1

    /**
     * 点击事件
     */
    private var listener: OnItemClickListener? = null
    /**
     * 是否自动刷新点击的item
     */
    private var needAutoRefreshClickItem = false
    /**
     * 是否自动设置当前点击的position为clickIndex
     */
    private var needAutoSetClickIndex = true
    /**
     * 是否自动过滤空数据
     */
    private var needAutoFilterEmptyData = true

    private val timeCell: TimeCell by lazy {
        TimeCell()
    }

    init {
        addAllData(dataList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        val holder = getViewHolder(parent, viewType)
        setHolderListener(holder)
        return holder
    }

    /**
     * 给holder提供数据
     * 绑定点击事件
     */
    override fun onBindViewHolder(@NonNull holder: BaseRecyclerViewHolder<T>, position: Int) {
        holder.bindViewHolder(getData(position), position)
    }

    /**
     * 抽象方法得到子类viewHolder
     */
    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T>

    /**
     * 列表长度
     */
    override fun getItemCount(): Int = length

    /**
     * 得到当前点击的itemIndex
     */
    fun getClickIndex(): Int = clickIndex

    /**
     * 主动设置选中的itemIndex
     */
    open fun setClickIndex(clickIndex: Int) {
        if (!isItemIndex(clickIndex)) return
        val preClickIndex = this.clickIndex
        this.clickIndex = clickIndex
        if (needAutoRefreshClickItem && preClickIndex != clickIndex) {
            notifyItemChanged(preClickIndex)
            notifyItemChanged(clickIndex)
        }
    }

    /**
     * @return 绑定的数据集合
     */
    fun getData(): List<T?> = list

    /**
     * @return 绑定的某个位置的数据
     */
    fun getData(position: Int): T? = if (isDataIndex(position)) list[position] else null

    /**
     * 绑定点击事件
     * @param listener 点击事件接口
     */
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    /**
     * 设置是否自动刷新点击的click，默认关闭
     */
    fun setNeedAutoRefreshClickItem(needAutoRefreshClickItem: Boolean) {
        this.needAutoRefreshClickItem = needAutoRefreshClickItem
    }

    /**
     * 设置是否自动设置选中的item为当前点击的item，默认开启
     */
    fun setNeedAutoSetClickIndex(needAutoSetClickIndex: Boolean) {
        this.needAutoSetClickIndex = needAutoSetClickIndex
    }

    /**
     * 是否过滤空数据
     */
    fun setNeedAutoFilterEmptyData(needAutoFilterEmptyData: Boolean) {
        this.needAutoFilterEmptyData = needAutoFilterEmptyData
    }

    /**
     * 设置点击事件
     * @param v 点击的视图
     */
    open fun clickEvent(v: View, position: Int) {
        if (!fastClick() && !click(v, position)) {
            if (needAutoSetClickIndex) {
                setClickIndex(position)
            }
            listener?.onClick(v, position)
        }
    }

    /**
     * 添加单个数据
     */
    fun addData(data: T?) {
        if (needAutoFilterEmptyData && data == null) {
            return
        }
        list.add(data)
    }

    /**
     * 添加数据列表
     */
    fun addAllData(dataList: List<T?>?) {
        if (dataList != null) {
            if (needAutoFilterEmptyData) {
                for (data in dataList) {
                    addData(data)
                }
            } else {
                list.addAll(dataList)
            }
        }
    }

    /**
     * 设置某个位置的数据
     */
    fun setData(position: Int, data: T?) {
        if (isDataIndex(position)) {
            if (data == null && needAutoFilterEmptyData) {
                removeData(position)
            } else {
                list[position] = data
            }
        }
    }

    /**
     * 设置list
     */
    fun setDataList(data: List<T?>?) {
        clear()
        addAllData(data)
    }

    /**
     * 移除某个位置的数据
     */
    fun removeData(position: Int) {
        if (isDataIndex(position)) {
            list.removeAt(position)
        }
    }

    /**
     * 列表中某个数据的位置
     */
    fun getIndex(data: T): Int = list.indexOf(data)

    /**
     * 刷新添加某个数据后的视图
     */
    open fun add(data: T) {
        addData(data)
        notifyItemInserted(itemCount)
    }

    /**
     * 刷新添加数据列表后的视图
     */
    open fun addAll(data: List<T?>) {
        addAllData(data)
        notifyItemRangeInserted(itemCount - data.size, data.size)
    }

    /**
     * 刷新移除某个位置的数据后的视图
     */
    open fun remove(position: Int) {
        removeData(position)
        notifyItemRemoved(position)
    }

    /**
     * 刷新全部数据
     */
    open fun refresh(data: List<T?>?) {
        setDataList(data)
        notifyDataSetChanged()
    }

    /**
     * 刷新某个数据
     */
    open fun replace(position: Int, data: T) {
        setData(position, data)
        notifyItemChanged(position)
    }

    /**
     * 适用于提前加载数据的情况
     */
    open fun getPreData(): MutableList<T?> {
        return ArrayList()
    }

    /**
     * 清空数据
     */
    open fun clear() {
        list.clear()
    }

    /**
     * 获取创建viewHolder时的view
     * 顺便取一下context
     */
    open fun getView(viewGroup: ViewGroup, layout: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
    }

    /**
     * 设置item中控件的点击事件
     */
    protected fun setListener(view: View?, position: Int) {
        if (isItemIndex(position)) {
            view?.setOnClickListener {
                clickEvent(view, position)
            }
        }
    }

    /**
     * 设置item中控件的点击事件
     */
    protected fun setHolderListener(holder: BaseRecyclerViewHolder<*>) {
        val view = holder.itemView
        view.setOnClickListener {
            clickEvent(view, holder.getHolderPosition())
        }
    }

    /**
     * 是否是数组下标
     */
    open fun isDataIndex(position: Int): Boolean = position in 0 until length

    /**
     * 是否是item下标
     */
    open fun isItemIndex(position: Int): Boolean = position in 0 until itemCount

    open fun isFirstData(position: Int) = position == 0

    open fun isLastData(position: Int) = position == length - 1

    /**
     * item点击间隔
     */
    open fun getClickDoubleTime(): Int = 500

    /**
     * 拿一个全局context用来加载资源
     */
    private fun getAppContext(): Context = KTApp.appContext

    /**
     * 处理内部点击事件
     * 可用于处理点击去重
     * @return 是否消费掉了此次点击事件
     */
    open fun click(v: View?, position: Int): Boolean = false

    /**
     * 防止重复点击
     */
    private fun fastClick(): Boolean {
        return timeCell.fastClick(0,500)
    }

}