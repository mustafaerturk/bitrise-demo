package com.bitrise.demo.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FetchListRepositoryImp : FetchListRepository {

    override fun getTitleList(): Flow<List<String>> {
        return flowOf(
            List(20) { index -> "Title $index" })
    }
}
