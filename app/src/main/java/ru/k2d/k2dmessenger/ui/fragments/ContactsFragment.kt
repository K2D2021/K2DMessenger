package ru.k2d.k2dmessenger.ui.fragments

import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY


class ContactsFragment : BaseFragment(R.layout.fragment_contacts) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Contacts"
    }
}