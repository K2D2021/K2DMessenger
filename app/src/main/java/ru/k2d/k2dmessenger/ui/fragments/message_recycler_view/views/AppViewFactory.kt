package ru.k2d.k2dmessenger.ui.fragments.message_recycler_view.views

import ru.k2d.k2dmessenger.models.CommonModel
import ru.k2d.k2dmessenger.utilits.TYPE_MESSAGE_IMAGE

class AppViewFactory {
    companion object {
        fun getView(message: CommonModel): MessageView {
            return when (message.type) {
                TYPE_MESSAGE_IMAGE -> ViewImageMessage(
                    message.id,
                    message.from,
                    message.timeStamp.toString(),
                    message.fileUrl
                )
                else -> ViewTextMessage(
                    message.id,
                    message.from,
                    message.timeStamp.toString(),
                    message.fileUrl,
                    message.text
                )
            }
        }
    }
}