package com.bitrise.demo.domain.di

import com.bitrise.demo.domain.FetchListRepository
import com.bitrise.demo.domain.FetchListRepositoryImp

object FetchListRepositoryProvider {

    private var repository: FetchListRepository? = null

    fun createRepo(): FetchListRepository {
        return if (repository == null) {
            repository = FetchListRepositoryImp()
            repository!!
        } else {
            repository!!
        }
    }
}
