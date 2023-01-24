package ru.k2d.k2dmessenger.ui.fragments.single_chat

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.k2d.k2dmessenger.database.CURRENT_UID
import ru.k2d.k2dmessenger.ui.fragments.message_recycler_view.view_holders.AppHolderFactory
import ru.k2d.k2dmessenger.ui.fragments.message_recycler_view.view_holders.HolderImageMessage
import ru.k2d.k2dmessenger.ui.fragments.message_recycler_view.view_holders.HolderTextMessage
import ru.k2d.k2dmessenger.ui.fragments.message_recycler_view.views.MessageView
import ru.k2d.k2dmessenger.utilits.asTime
import ru.k2d.k2dmessenger.utilits.downloadAndSetImage

class SingleChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mlistMessagesCache = mutableListOf<MessageView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppHolderFactory.getHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    private fun drawMessageImage(holder: HolderImageMessage, position: Int) {
        if (mlistMessagesCache[position].from == CURRENT_UID) {
            holder.blocReceivedImageMessage.visibility = View.GONE
            holder.blocUserImageMessage.visibility = View.VISIBLE
            holder.chatUserImage.downloadAndSetImage(mlistMessagesCache[position].fileUrl)
            holder.chatUserImageMessageTime.text =
                mlistMessagesCache[position].timeStamp.toString().asTime()
        } else {
            holder.blocReceivedImageMessage.visibility = View.VISIBLE
            holder.blocUserImageMessage.visibility = View.GONE
            holder.chatReceivedImage.downloadAndSetImage(mlistMessagesCache[position].fileUrl)
            holder.chatReceivedImageMessageTime.text =
                mlistMessagesCache[position].timeStamp.toString().asTime()
        }
    }

    private fun drawMessageText(holder: HolderTextMessage, position: Int) {
        if (mlistMessagesCache[position].from == CURRENT_UID) {
            holder.blocUserMessage.visibility = View.VISIBLE
            holder.blocReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = mlistMessagesCache[position].text
            holder.chatUserMessageTime.text =
                mlistMessagesCache[position].timeStamp.toString().asTime()
        } else {
            holder.blocUserMessage.visibility = View.GONE
            holder.blocReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = mlistMessagesCache[position].text
            holder.chatReceivedMessageTime.text =
                mlistMessagesCache[position].timeStamp.toString().asTime()
        }
    }

    override fun getItemCount(): Int = mlistMessagesCache.size

    fun addItemToBottom(item: MessageView, onSuccess: () -> Unit) {
        if (!mlistMessagesCache.contains(item)) {
            mlistMessagesCache.add(item)
            notifyItemInserted(mlistMessagesCache.size)
        }
        onSuccess()
    }

    fun addItemToTop(item: MessageView, onSuccess: () -> Unit) {
        if (!mlistMessagesCache.contains(item)) {
            mlistMessagesCache.add(item)
            mlistMessagesCache.sortBy { it.timeStamp.toString() }
            notifyItemInserted(0)
        }
        onSuccess()
    }

}

