package yovi.putra.gridsectionlayout

import android.view.View
import kotlinx.android.synthetic.main.header.view.*

class HeaderVHolder(itemView: View) : BaseVHolder<Item>(itemView) {
    override fun binding(data: Item) {
        itemView.apply {
            tv_title.text = data.title
        }
    }
}