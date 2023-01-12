package ru.k2d.k2dmessenger.utilits

import androidx.recyclerview.widget.DiffUtil
import ru.k2d.k2dmessenger.models.CommonModel

class DiffUtilCallback(private val oldList: List<CommonModel>, private val newList: List<CommonModel>):DiffUtil.Callback() {
    override fun getOldListSize(): Int {

    }

    override fun getNewListSize(): Int {
        TODO("Not yet implemented")
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }
}