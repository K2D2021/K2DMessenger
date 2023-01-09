package ru.k2d.k2dmessenger.ui.fragments.single_chat

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item.view.*
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.utilits.CURRENT_UID
import ru.k2d.k2dmessenger.utilits.asTime

class SingleChatAdapter: RecyclerView.Adapter<SingleChatAdapter.SingleChatHolder>() {

    private var mlistMessagesCache = emptyList<CommonModel>()

    class SingleChatHolder(view: View) : RecyclerView.ViewHolder(view){
        val blocUserMessage:ConstraintLayout = view.bloc_user_message
        val chatUserMessage:TextView = view.chat_user_message
        val chatUserMessageTime:TextView = view.chat_user_message_time

        val blocReceivedMessage:ConstraintLayout = view.bloc_received_message
        val chatReceivedMessage:TextView = view.chat_received_message
        val chatReceivedMessageTime:TextView = view.chat_received_message_time
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false)
        return SingleChatHolder(view)
    }

    override fun onBindViewHolder(holder: SingleChatHolder, position: Int) {
        if(mlistMessagesCache[position].from == CURRENT_UID){
            holder.blocUserMessage.visibility = View.VISIBLE
            holder.blocReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = mlistMessagesCache[position].text
            holder.chatUserMessageTime.text = mlistMessagesCache[position].timeStamp.asTime()
        } else {
            holder.blocUserMessage.visibility = View.GONE
            holder.blocReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = mlistMessagesCache[position].text
            holder.chatReceivedMessageTime.text = mlistMessagesCache[position].timeStamp.asTime()
        }
    }

    override fun getItemCount(): Int = mlistMessagesCache.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CommonModel>){
        mlistMessagesCache = list
        notifyDataSetChanged()
    }
}

