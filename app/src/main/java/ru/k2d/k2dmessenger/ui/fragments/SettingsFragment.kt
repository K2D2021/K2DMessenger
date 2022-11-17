package ru.k2d.k2dmessenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import ru.k2d.k2dmessenger.R

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu,menu)
    }
}