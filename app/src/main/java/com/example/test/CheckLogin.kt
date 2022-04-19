package com.example.test

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * 检查登录注解
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(
    RetentionPolicy.RUNTIME
)
annotation class CheckLogin(
    /**
     * 间隔
     */
    val interval: Int = 5000
)