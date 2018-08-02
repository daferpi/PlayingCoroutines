package com.projects.abelfernandez.playingcoroutines.data

import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import kotlinx.coroutines.experimental.launch

interface IItemDataRepository {
    companion object {
        fun create():IItemDataRepository {
            return ItemDataRepository()
        }
    }

    fun findAllItems():List<Item>
}

class ItemDataRepository(private val api: GithubApi = GithubApi.create()):IItemDataRepository {


    override fun findAllItems(): List<Item> {

        var itemsList = listOf<Item>()
        launch {
            try {

                val response = api.findAllRepositories().await()

                if (response.isSuccessful) {
                    if (response.body() != null) {
                        itemsList = response.body()!!
                    }
                }
            } catch (exception:Exception) {
                System.out.println(exception.localizedMessage)
            }
        }

        return itemsList

    }

}