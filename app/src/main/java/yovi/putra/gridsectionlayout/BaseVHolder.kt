package yovi.putra.gridsectionlayout

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVHolder<DATA>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun binding(data: DATA)
}