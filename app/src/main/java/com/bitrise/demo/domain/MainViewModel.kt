package com.bitrise.demo.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val fetchListUseCase = FetchListUseCase()

    private val _titleList = MutableStateFlow<List<String>>(emptyList())
    val titleList: StateFlow<List<String>> = _titleList

    fun fetch() {
        viewModelScope.launch {
            fetchListUseCase.invoke().collectLatest { fetchedList ->
                _titleList.update {
                    fetchedList
                }
            }
        }
    }
}
