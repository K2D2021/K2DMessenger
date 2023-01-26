package ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item_text.view.*
import ru.k2d.k2dmessenger.database.CURRENT_UID
import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView
import ru.k2d.k2dmessenger.utilits.asTime

class HolderTextMessage(view: View) : RecyclerView.ViewHolder(view) {
    val blocUserMessage: ConstraintLayout = view.bloc_user_message
    val chatUserMessage: TextView = view.chat_user_message
    val chatUserMessageTime: TextView = view.chat_user_message_time

    val blocReceivedMessage: ConstraintLayout = view.bloc_received_message
    val chatReceivedMessage: TextView = view.chat_received_message
    val chatReceivedMessageTime: TextView = view.chat_received_message_time

    fun drawMessageText(holder: HolderTextMessage, view: MessageView) {
        if (view.from == CURRENT_UID) {
            holder.blocUserMessage.visibility = View.VISIBLE
            holder.blocReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = view.text
            holder.chatUserMessageTime.text =
                view.timeStamp.asTime()
        } else {
            holder.blocUserMessage.visibility = View.GONE
            holder.blocReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = view.text
            holder.chatReceivedMessageTime.text =
                view.timeStamp.asTime()
        }
    }
}