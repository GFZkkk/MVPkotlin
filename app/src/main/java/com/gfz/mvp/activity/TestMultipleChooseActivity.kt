package com.gfz.mvp.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.gfz.mvp.adapter.TestMultipleChooseAdapter
import com.gfz.mvp.base.BaseActivity
import com.gfz.mvp.databinding.ActivityMultiChooseBinding
import com.gfz.mvp.model.bean.MultipleChooseBean
import com.gfz.mvp.utils.viewBind
import java.util.*


/**
 * created by gaofengze on 2020/4/14
 */

class TestMultipleChooseActivity : BaseActivity() {

    private val binding: ActivityMultiChooseBinding by viewBind()

    override fun initData() {
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val adapter = TestMultipleChooseAdapter()

        adapter.addAll(object : ArrayList<MultipleChooseBean>() {
            init {
                add(MultipleChooseBean("这是第一条", 1))
                add(MultipleChooseBean("这是第二条", 1))
                add(MultipleChooseBean("这是第三条", 2))
                add(MultipleChooseBean("这是第四条", 3))
                add(MultipleChooseBean("这是第五条", 4))
                add(MultipleChooseBean("这是第六条", 4))
                add(MultipleChooseBean("这是第七条", 4))
                add(MultipleChooseBean("这是第八条", 5))
                add(MultipleChooseBean("这是第九条", 5))
                add(MultipleChooseBean("这是第十条", 5))
                add(MultipleChooseBean("这是第十一条", 5))
                add(MultipleChooseBean("这是第十二条", 6))
                add(MultipleChooseBean("这是第一条", 6))
                add(MultipleChooseBean("这是第二条", 6))
            }
        })

        binding.rvList.adapter = adapter
    }
}