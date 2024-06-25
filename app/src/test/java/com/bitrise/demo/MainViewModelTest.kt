package com.bitrise.demo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bitrise.demo.domain.MainViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule: MainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `when fetch clicked check state`() = runTest {
        viewModel.fetch()

        val result = viewModel.titleList.value

        Assert.assertTrue(result.isNotEmpty())
    }

    @Test
    fun `assert always true`() = runTest {
        Assert.assertTrue(true)
    }
}
