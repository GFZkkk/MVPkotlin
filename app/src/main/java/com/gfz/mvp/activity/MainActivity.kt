package com.gfz.mvp.activity

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gfz.mvp.adapter.Test3Adapter
import com.gfz.mvp.base.BaseActivity

import com.gfz.mvp.callback.OnItemClickListener
import com.gfz.mvp.databinding.ActivityMainBinding
import com.gfz.mvp.model.bean.TestBean
import com.gfz.mvp.utils.viewBind
import kotlin.system.exitProcess

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by viewBind()

    override fun initData() {
        val adapter = Test3Adapter()
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = GridLayoutManager(this, 2)
        adapter.refresh(listOf(TestBean("日历试验区"),
            TestBean("滑动多选试验区"),
            TestBean("悬浮计时试验区"),
            TestBean("时钟试验区"),
            TestBean("移动列表实验区"),
            TestBean("自定义动画实验区"),
            TestBean("扩展布局实验区"),
            TestBean("自定义下划线试验区")
        ))
        adapter.setOnItemClickListener { _, position ->
            when (position) {
                0 -> startActivity(Intent(this, TestCalendarActivity::class.java))
                1 -> startActivity(Intent(this, TestMultipleChooseActivity::class.java))
                2 -> startActivity(Intent(this, TestCountDownActivity::class.java))
                3 -> startActivity(Intent(this, TestClockActivity::class.java))
                4 -> startActivity(Intent(this, TestMoveActivity::class.java))
                5 -> startActivity(Intent(this, TestAnimationActivity::class.java))
                6 -> startActivity(Intent(this, TestExtAdapterActivity::class.java))
                7 -> startActivity(Intent(this, TestUnderlineActivity::class.java))
            }
        }
    }

    override fun onBackPressed() {
        if(fastClick(-1, 1500)){
            finish()
            exitProcess(0);
        }else{
            showToast("再按一次退出")
        }

    }
}
