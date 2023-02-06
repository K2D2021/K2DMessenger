package ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item_file.view.*
import ru.k2d.k2dmessenger.database.CURRENT_UID
import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView
import ru.k2d.k2dmessenger.utilits.asTime

class HolderFileMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {

    private val blocReceivedFileMessage: ConstraintLayout = view.bloc_received_file_message
    private val blocUserFileMessage: ConstraintLayout = view.bloc_user_file_message
    private val chatReceivedFileMessageTime: TextView = view.chat_received_file_message_time
    private val chatUserFileMessageTime: TextView = view.chat_user_file_message_time



    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocReceivedFileMessage.visibility = View.GONE
            blocUserFileMessage.visibility = View.VISIBLE
            chatUserFileMessageTime.text =
                view.timeStamp.asTime()
        } else {
            blocReceivedFileMessage.visibility = View.VISIBLE
            blocUserFileMessage.visibility = View.GONE
            chatReceivedFileMessageTime.text =
                view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {

    }

    override fun onDetach() {

    }
}