package ru.k2d.k2dmessenger.ui.message_recycler_view.view_holders

import ru.k2d.k2dmessenger.ui.message_recycler_view.views.MessageView

interface MessageHolder {
    fun drawMessage(view: MessageView)
}