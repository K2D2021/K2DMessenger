package ru.k2d.k2dmessenger.ui.screens.single_chat

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders.AppHolderFactory
import ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders.HolderImageMessage
import ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders.HolderTextMessage
import ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders.HolderVoiceMessage
import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView

class SingleChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mlistMessagesCache = mutableListOf<MessageView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppHolderFactory.getHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return mlistMessagesCache[position].getTypeView()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HolderImageMessage -> holder.drawMessageImage(holder, mlistMessagesCache[position])
            is HolderVoiceMessage -> holder.drawMessageVoice(holder, mlistMessagesCache[position])
            is HolderTextMessage -> holder.drawMessageText(holder, mlistMessagesCache[position])
            else -> {}
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
            mlistMessagesCache.sortBy { it.timeStamp }
            notifyItemInserted(0)
        }
        onSuccess()
    }

}

