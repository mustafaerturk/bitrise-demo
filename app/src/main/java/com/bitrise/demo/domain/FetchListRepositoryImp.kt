package com.bitrise.demo.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onStart

class FetchListRepositoryImp : FetchListRepository {

    override fun getTitleList(): Flow<List<String>> {
        return flowOf(
            List(20) { index -> "Title $index" })
            .onStart {
                delay(500L)
            }
    }
}
