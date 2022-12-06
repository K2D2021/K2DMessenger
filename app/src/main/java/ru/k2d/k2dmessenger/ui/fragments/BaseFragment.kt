package ru.k2d.k2dmessenger.ui.fragments

import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.MainActivity

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mAppDrawer.enableDrawer()

    }
}