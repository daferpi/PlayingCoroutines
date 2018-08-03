package com.projects.abelfernandez.playingcoroutines.domain.interactor

import com.projects.abelfernandez.playingcoroutines.asyncAwait
import com.projects.abelfernandez.playingcoroutines.data.IItemDataRepository
import com.projects.abelfernandez.playingcoroutines.data.Result
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import com.projects.abelfernandez.playingcoroutines.launchAsync

interface IItemDataInteractor {
    companion object {
        fun create():IItemDataInteractor {
            return ItemDataInteractor(IItemDataRepository.create())
        }
    }

    fun findAllItems(func:(Result<List<Item>>) -> Unit)
}

class ItemDataInteractor(private val repository: IItemDataRepository) : IItemDataInteractor {

    override fun findAllItems(func:(Result<List<Item>>) -> Unit) {
        launchAsync {
            val result = asyncAwait { repository.findAllItems() }
            func(result)
        }
    }
}
