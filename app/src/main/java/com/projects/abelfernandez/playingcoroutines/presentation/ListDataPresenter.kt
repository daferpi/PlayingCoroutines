package com.projects.abelfernandez.playingcoroutines.presentation
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import com.projects.abelfernandez.playingcoroutines.domain.interactor.IItemDataInteractor


interface IListDataPresenter {
    companion object {
        fun create():IListDataPresenter {
            return ListDataPresenter(IItemDataInteractor.create())
        }
    }

    fun findAllItems():List<Item>
}

class ListDataPresenter(private val interactor:IItemDataInteractor):IListDataPresenter {

    override fun findAllItems(): List<Item> {
        return interactor.findAllItems()
    }


}