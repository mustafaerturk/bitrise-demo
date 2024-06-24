package com.bitrise.demo.domain

import kotlinx.coroutines.flow.Flow

interface FetchListRepository {
    fun getTitleList(): Flow<List<String>>
}
