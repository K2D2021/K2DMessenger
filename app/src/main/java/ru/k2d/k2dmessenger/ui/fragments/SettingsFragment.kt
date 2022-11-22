package ru.k2d.k2dmessenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ru.k2d.k2dmessenger.MainActivity
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.activities.RegisterActivity
import ru.k2d.k2dmessenger.utilits.AUTH
import ru.k2d.k2dmessenger.utilits.replaceActivity

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}