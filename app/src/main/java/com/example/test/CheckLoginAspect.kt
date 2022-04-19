package com.example.test

import android.util.Log
import android.widget.Toast
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature

/**
 * 检查登录切面
 */
@Aspect
class CheckLoginAspect {

    companion object {
        @JvmStatic
        fun aspectOf(): CheckLoginAspect {
            return CheckLoginAspect()
        }
    }

    @Around("execution(* *(..))")
    @Throws(Throwable::class)
    fun doBeforeOnClick(joinPoint: ProceedingJoinPoint) {
        Log.e(TAGConstant.TAG, "doBeforeOnClick 执行")
        try {
            // 获取方法
            val methodSignature = joinPoint.signature as MethodSignature
            Log.e(TAGConstant.TAG, "方法名字：" + methodSignature.method.name)

            // 获取方法上面的注解
            val checkLogin = methodSignature.method.getAnnotation(CheckLogin::class.java)

            // 判断注解是否为空
            if (checkLogin == null) {
                Log.e(TAGConstant.TAG, "CheckLogin注解为空")
                joinPoint.proceed()
                return
            }

            // 注解不为空
            Log.e(TAGConstant.TAG, "CheckLogin注解不为空")
            // 检查登录状态,如果登录,继续执行下面的方法，如果没有登录，跳转到登录界面
            LoginService.checkLogin(object : LoginStateListener {
                override fun logined() {
                    Log.e(TAGConstant.TAG, "登录成功，继续执行")
                    try {
                        joinPoint.proceed()
                    } catch (throwable: Throwable) {
                        throwable.printStackTrace()
                    }
                }

                override fun unlogin() {
                    Log.e(TAGConstant.TAG, "登录失败，跳转到登录界面")
                }
            })
        } catch (e: Exception) {
            joinPoint.proceed()
        }
    }
}