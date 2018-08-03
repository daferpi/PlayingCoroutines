package com.projects.abelfernandez.playingcoroutines.data

import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import kotlinx.coroutines.experimental.launch

interface IItemDataRepository {
    companion object {
        fun create():IItemDataRepository {
            return ItemDataRepository()
        }
    }

    suspend fun findAllItems():Result<List<Item>>
}

class ItemDataRepository(private val api: GithubApi = GithubApi.create()):IItemDataRepository {


    override suspend fun findAllItems(): Result<List<Item>> {

        var itemsListResult = Result.Success(listOf<Item>())
        try {

            val response = api.findAllRepositories().await()

            if (response.isSuccessful) {
                if (response.body() != null) {
                    itemsListResult = Result.Success(response.body()!!)
                }
            } else {
                Result.Error(Exception())
            }
        } catch (exception:Exception) {
            System.out.println(exception.localizedMessage)
            Result.Error(Exception())
        }

        return itemsListResult

    }

}