package com.projects.abelfernandez.playingcoroutines.presentation
import com.projects.abelfernandez.playingcoroutines.data.Result
import com.projects.abelfernandez.playingcoroutines.domain.interactor.IItemDataInteractor


interface IListDataPresenter {

    fun findAllItems()
}

class ListDataPresenter(private val view: IListDataView, private val interactor:IItemDataInteractor):IListDataPresenter {


    override fun findAllItems() {
        interactor.findAllItems {
            when (it) {
                is Result.Success -> view.showListItems(it.data)
                is Result.Error -> view.showError(it.exception)
            }
        }
    }




}