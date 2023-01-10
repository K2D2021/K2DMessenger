package ru.k2d.k2dmessenger.ui.fragments

import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY

class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "K2DMessenger"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}