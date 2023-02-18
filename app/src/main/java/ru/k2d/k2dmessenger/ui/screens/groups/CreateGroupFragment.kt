package ru.k2d.k2dmessenger.ui.screens.groups

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_create_group.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.ui.screens.base.BaseFragment
import ru.k2d.k2dmessenger.utilits.APP_ACTIVITY
import ru.k2d.k2dmessenger.utilits.getPlurals
import ru.k2d.k2dmessenger.utilits.hideKeyboard
import ru.k2d.k2dmessenger.utilits.showToast

class CreateGroupFragment(private var listContacts: List<CommonModel>) :
    BaseFragment(R.layout.fragment_create_group) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddContactsAdapter
    private var mUri = Uri.EMPTY

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.create_group)
        hideKeyboard()
        initRecyclerView()
        create_group_photo.setOnClickListener{ addPhoto()}
        create_group_btn_complete.setOnClickListener { showToast("Click") }
        create_group_input_name.requestFocus()
        create_group_counts.text = getPlurals(listContacts.size)
    }

    private fun addPhoto() {
        CropImage.activity()
            .setAspectRatio(1, 1)
            .setRequestedSize(256, 256)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(APP_ACTIVITY, this)
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