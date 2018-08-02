package com.projects.abelfernandez.playingcoroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.projects.abelfernandez.playingcoroutines.presentation.IListDataView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentFragment()
    }

    private fun setContentFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.main_container, IListDataView.create())
            commit()
        }
    }
}
