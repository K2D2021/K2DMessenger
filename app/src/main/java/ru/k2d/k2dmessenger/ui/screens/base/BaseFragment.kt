package ru.k2d.k2dmessenger.ui.screens.base

import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }
}