package ru.k2d.k2dmessenger.ui.screens.groups

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_contacts.*
import kotlinx.android.synthetic.main.fragment_create_group.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.database.*
import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.ui.screens.base.BaseFragment
import ru.k2d.k2dmessenger.utilits.*

class CreateGroupFragment(private var listContacts: List<CommonModel>) :
    BaseFragment(R.layout.fragment_create_group) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddContactsAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.create_group)
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
        initRecyclerView()
        create_group_btn_complete.setOnClickListener { showToast("Click") }
    }

    private fun initRecyclerView() {
        mRecyclerView = create_group_recycle_view
        mAdapter = AddContactsAdapter()

        mRecyclerView.adapter = mAdapter
        listContacts.forEach {
            mAdapter.updateListItems(it)
        }
    }
}