package ru.k2d.k2dmessenger.ui.screens.settings

import kotlinx.android.synthetic.main.fragment_change_name.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.database.*
import ru.k2d.k2dmessenger.ui.screens.base.BaseChangeFragment
import ru.k2d.k2dmessenger.utilits.*

class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        initFullnameList()
    }

    private fun initFullnameList() {
        val fullnameList = USER.fullname.split(" ")
        if (fullnameList.size > 1) {
            settings_input_name.setText(fullnameList[0])
            settings_input_surname.setText(fullnameList[1])
        } else settings_input_name.setText(fullnameList[0])
    }

    override fun change() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) showToast(getString(R.string.settings_toast_name_is_empty)) else {
            val fullname = "$name $surname"

            setNameToDatabase(fullname)
        }
    }
}