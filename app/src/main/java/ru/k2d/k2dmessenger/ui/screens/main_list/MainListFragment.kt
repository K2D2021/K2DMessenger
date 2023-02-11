package ru.k2d.k2dmessenger.ui.screens.main_list

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main_list.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY
import ru.k2d.k2dmessenger.utilits.hideKeyboard

class MainListFragment : Fragment(R.layout.fragment_main_list) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MainListAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "K2DMessenger"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = main_list_recycle_view
        mAdapter = MainListAdapter()
    }
}