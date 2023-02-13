package ru.k2d.k2dmessenger.ui.screens.settings

import kotlinx.android.synthetic.main.fragment_change_username.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.database.*
import ru.k2d.k2dmessenger.ui.screens.BaseChangeFragment
import ru.k2d.k2dmessenger.utilits.*


class ChangeUsernameFragment : BaseChangeFragment(R.layout.fragment_change_username) {

    private lateinit var mNewUsername: String
    override fun onResume() {
        super.onResume()
        settings_input_username.setText(USER.username)
    }

    override fun change() {
        mNewUsername = settings_input_username.text.toString().lowercase()
        if (mNewUsername.isEmpty()) {
            showToast("Field is empty")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                    if (it.hasChild(mNewUsername)) {
                        showToast("This username is already exist")
                    } else {
                        changeUsername()
                    }
                })
        }
    }

    private fun changeUsername() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUsername).setValue(CURRENT_UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateCurrentUsername(mNewUsername)
                }
            }
    }
}
