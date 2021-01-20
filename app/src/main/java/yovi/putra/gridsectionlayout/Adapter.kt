package yovi.putra.gridsectionlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<BaseVHolder<Item>>() {
    private val item = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVHolder<Item> {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == Item.VIEW_TYPE_HEADER) {
            HeaderVHolder(
                inflater.inflate(R.layout.header, parent, false)
            )
        } else if (viewType == Item.VIEW_TYPE_ITEM) {
            ItemVHolder(
                inflater.inflate(R.layout.item, parent, false)
            )
        } else {
            ListVHolder(
                inflater.inflate(R.layout.list, parent, false)
            )
        }
    }

    fun isHeader(pos: Int) : Boolean = item[pos].type == Item.VIEW_TYPE_HEADER

    override fun getItemViewType(position: Int): Int {
        return item[position].type
    }

    fun setItem(item: Item) {
        this.item.add(item)
        this.notifyDataSetChanged()
    }

    fun setItem(item: MutableList<Item>) {
        this.item.addAll(item)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: BaseVHolder<Item>, position: Int) {
        holder.binding(item[position])
    }
}