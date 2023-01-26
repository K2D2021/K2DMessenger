package ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item_image.view.*
import ru.k2d.k2dmessenger.database.CURRENT_UID
import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView
import ru.k2d.k2dmessenger.utilits.asTime
import ru.k2d.k2dmessenger.utilits.downloadAndSetImage

class HolderImageMessage(view: View) : RecyclerView.ViewHolder(view) {
    val blocReceivedImageMessage: ConstraintLayout = view.bloc_received_image_message
    val blocUserImageMessage: ConstraintLayout = view.bloc_user_image_message
    val chatReceivedImage: ImageView = view.chat_received_image
    val chatUserImage: ImageView = view.chat_user_image
    val chatReceivedImageMessageTime: TextView = view.chat_received_image_message_time
    val chatUserImageMessageTime: TextView = view.chat_user_image_message_time

    fun drawMessageImage(holder: HolderImageMessage, view: MessageView) {
        if (view.from == CURRENT_UID) {
            holder.blocReceivedImageMessage.visibility = View.GONE
            holder.blocUserImageMessage.visibility = View.VISIBLE
            holder.chatUserImage.downloadAndSetImage(view.fileUrl)
            holder.chatUserImageMessageTime.text =
                view.timeStamp.asTime()
        } else {
            holder.blocReceivedImageMessage.visibility = View.VISIBLE
            holder.blocUserImageMessage.visibility = View.GONE
            holder.chatReceivedImage.downloadAndSetImage(view.fileUrl)
            holder.chatReceivedImageMessageTime.text =
                view.timeStamp.asTime()
        }
    }
}