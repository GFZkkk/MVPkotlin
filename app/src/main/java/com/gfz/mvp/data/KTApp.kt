package com.gfz.mvp.data

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.gfz.mvp.base.KTCatchException
import com.gfz.mvp.utils.TopLog
import kotlin.properties.Delegates

/**
 * created by gaofengze on 2020-01-19
 */

class KTApp: Application() {

    companion object{
        var appContext: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        TopLog.init(true)
        KTCatchException.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}