package com.example.test

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper

class MyApp : Application() {

    companion object {
        val mContext by lazy {
            this
        }

        @JvmField
        var isLogin = false
        @JvmStatic
        val handler by lazy {
            Handler(Looper.getMainLooper())
        }
    }
}