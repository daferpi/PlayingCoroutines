package com.projects.abelfernandez.playingcoroutines.presentation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.projects.abelfernandez.playingcoroutines.R
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import com.projects.abelfernandez.playingcoroutines.domain.interactor.IItemDataInteractor
import kotlinx.android.synthetic.main.content_main.*

interface IListDataView {
    companion object {
        fun create() = ListDataFragment.newInstance()
    }

    fun showListItems(itemsList:List<Item>)
    fun showError(error:Throwable)

}


class ListDataFragment:Fragment(), IListDataView {

    lateinit var presenter:IListDataPresenter

    companion object {
        fun newInstance():ListDataFragment {
            val fragment = ListDataFragment()
            fragment.presenter = ListDataPresenter(fragment, IItemDataInteractor.create())
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.content_main, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.findAllItems()

        content_main_list.adapter = ListDataAdapter(listOf())
        content_main_list.layoutManager = LinearLayoutManager(this.context)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun showListItems(itemsList: List<Item>) {
        content_main_list.adapter = ListDataAdapter(itemsList)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this.context, "Error to show the list", Toast.LENGTH_SHORT).show()
    }

}