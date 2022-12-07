package ru.k2d.k2dmessenger.ui.fragments

import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.MainActivity
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        (APP_ACTIVITY).mAppDrawer.enableDrawer()

    }
}