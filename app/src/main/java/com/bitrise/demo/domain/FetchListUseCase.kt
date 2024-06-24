package com.bitrise.demo.domain

import com.bitrise.demo.domain.di.FetchListRepositoryProvider

class FetchListUseCase {

    private val repository = FetchListRepositoryProvider.createRepo()

    operator fun invoke() = repository.getTitleList()
}
