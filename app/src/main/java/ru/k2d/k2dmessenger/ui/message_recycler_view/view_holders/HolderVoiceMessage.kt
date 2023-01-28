package ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item_voice.view.*
import ru.k2d.k2dmessenger.database.CURRENT_UID
import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView
import ru.k2d.k2dmessenger.utilits.asTime

class HolderVoiceMessage(view: View) : RecyclerView.ViewHolder(view), MessageHolder {
    val blocReceivedVoiceMessage: ConstraintLayout = view.bloc_received_voice_message
    val blocUserVoiceMessage: ConstraintLayout = view.bloc_user_voice_message
    val chatReceivedVoiceMessageTime: TextView = view.chat_received_voice_message_time
    val chatUserVoiceMessageTime: TextView = view.chat_user_voice_message_time

    val chatReceivedBtnPlay: ImageView = view.chat_received_btn_play
    val chatReceivedBtnStop: ImageView = view.chat_received_btn_stop

    val chatUserBtnPlay: ImageView = view.chat_user_btn_play
    val chatUserBtnStop: ImageView = view.chat_user_btn_stop

    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blocReceivedVoiceMessage.visibility = View.GONE
            blocUserVoiceMessage.visibility = View.VISIBLE
            chatUserVoiceMessageTime.text =
                view.timeStamp.asTime()
        } else {
            blocReceivedVoiceMessage.visibility = View.VISIBLE
            blocUserVoiceMessage.visibility = View.GONE
            chatReceivedVoiceMessageTime.text =
                view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}