package ru.k2d.k2dmessenger.ui.screens.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.add_contacts_item.view.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.ui.screens.single_chat.SingleChatFragment
import ru.k2d.k2dmessenger.utilits.downloadAndSetImage
import ru.k2d.k2dmessenger.utilits.replaceFragment

class AddContactsAdapter : RecyclerView.Adapter<AddContactsAdapter.AddContactsHolder>() {

    private var listItems = mutableListOf<CommonModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddContactsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item,parent,false)
        val holder = AddContactsHolder(view)
        holder.itemView.setOnClickListener {
            replaceFragment(SingleChatFragment(listItems[holder.adapterPosition]))
        }
        return holder
    }

    override fun onBindViewHolder(holder: AddContactsHolder, position: Int) {
        holder.itemName.text = listItems[position].fullname
        holder.itemLastMessage.text = listItems[position].lastMessage
        holder.itemPhoto.downloadAndSetImage(listItems[position].photoUrl)
    }

    fun updateListItems(item:CommonModel){
        listItems.add(item)
        notifyItemInserted(listItems.size)
    }

    override fun getItemCount(): Int = listItems.size

    class AddContactsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.add_contacts_item_name
        val itemLastMessage: TextView = view.add_contacts_last_message
        val itemPhoto: CircleImageView = view.add_contacts_item_photo
        val itemChoice: CircleImageView = view.add_contacts_item_choice
    }
}