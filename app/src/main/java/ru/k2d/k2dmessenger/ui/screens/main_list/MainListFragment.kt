package ru.k2d.k2dmessenger.ui.screens.main_list

import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY
import ru.k2d.k2dmessenger.utilits.hideKeyboard

class MainListFragment : Fragment(R.layout.fragment_main_list) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "K2DMessenger"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }
}