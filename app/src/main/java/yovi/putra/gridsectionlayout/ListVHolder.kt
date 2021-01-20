package yovi.putra.gridsectionlayout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.list.view.*

class ListVHolder(itemView: View) : BaseVHolder<Item>(itemView) {
    override fun binding(data: Item) {
        itemView.apply {
            label.text = data.title
        }
    }
}