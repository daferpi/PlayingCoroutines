package com.projects.abelfernandez.playingcoroutines.presentation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projects.abelfernandez.playingcoroutines.R
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import kotlinx.android.synthetic.main.content_main.*

interface IListDataView {
    companion object {
        fun create() = ListDataFragment.newInstance()
    }

}


class ListDataFragment:Fragment(), IListDataView {

    private var itemsList = listOf<Item>()
    lateinit var presenter:IListDataPresenter

    companion object {
        fun newInstance():ListDataFragment {
            val fragment = ListDataFragment()
            fragment.presenter = IListDataPresenter.create()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.content_main, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        itemsList = presenter.findAllItems()

        content_main_list.adapter = ListDataAdapter(itemsList)
        content_main_list.layoutManager = LinearLayoutManager(this.context)

        super.onViewCreated(view, savedInstanceState)
    }

}