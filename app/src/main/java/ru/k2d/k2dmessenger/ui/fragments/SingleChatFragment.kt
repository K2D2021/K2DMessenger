package ru.k2d.k2dmessenger.ui.fragments

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.models.User
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY
import ru.k2d.k2dmessenger.utilits.AppValueEventListener


class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {

    private lateinit var mListenerInfoToolbar: AppValueEventListener
    private lateinit var mReceivingUser: User
    private lateinit var mToolbarInfo: View

    override fun onResume() {
        super.onResume()
        mToolbarInfo = APP_ACTIVITY.mToolbar.toolbar_info
        mToolbarInfo.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.GONE
    }

}