package com.projects.abelfernandez.playingcoroutines.domain.interactor

import com.projects.abelfernandez.playingcoroutines.data.IItemDataRepository
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item

interface IItemDataInteractor {
    companion object {
        fun create():IItemDataInteractor {
            return ItemDataInteractor(IItemDataRepository.create())
        }
    }

    fun findAllItems():List<Item>
}

class ItemDataInteractor(private val repository: IItemDataRepository) : IItemDataInteractor {

    override fun findAllItems(): List<Item> {
        return repository.findAllItems()
    }
}
