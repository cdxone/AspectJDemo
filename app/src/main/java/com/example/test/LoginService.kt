package com.example.test

import android.widget.Toast

class LoginService {

    companion object {

        @JvmStatic
        fun checkLogin(listenr: LoginStateListener) {
            // 模拟登录,4秒以后返回登录
            Thread {
                Thread.sleep(4000)
                if (MyApp.isLogin) {
                    MyApp.handler.post {
                        listenr.logined()
                    }
                } else {
                    MyApp.handler.post {
                        listenr.unlogin()
                    }
                }
            }.start()
        }
    }
}