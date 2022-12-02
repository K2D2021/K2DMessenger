package ru.k2d.k2dmessenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.k2d.k2dmessenger.MainActivity
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.activities.RegisterActivity
import ru.k2d.k2dmessenger.utilits.AUTH
import ru.k2d.k2dmessenger.utilits.USER
import ru.k2d.k2dmessenger.utilits.replaceActivity
import ru.k2d.k2dmessenger.utilits.replaceFragment

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_full_name.text = USER.fullname
        settings_phone_number.text = USER.phone
        settings_username.text = USER.username
        settings_bio.text = USER.bio
        settings_status.text = USER.status
        settings_btn_change_user_name.setOnClickListener{
            replaceFragment(ChangeUsernameFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> (replaceFragment(ChangeNameFragment()))
        }
        return true
    }
}