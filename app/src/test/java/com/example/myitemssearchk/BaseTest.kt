package com.example.myitemssearchk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.mockito.Mockito

open class BaseTest {

    @Rule
    @JvmField
    val testSchedulerRule = RxImmediateSchedulerRule()

    @get:Rule
    val testViewModelRule = InstantTaskExecutorRule()

    fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)

    inline fun <reified T : Any> getClassReference() = T::class.java
}
