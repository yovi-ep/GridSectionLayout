package yovi.putra.gridsectionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val itemAdapter = Adapter()
        val layout = GridLayoutManager(this, 4)
        recyclerview.apply {
            layoutManager = layout
            adapter = itemAdapter
        }

        layout.spanSizeLookup = AdapterSpanDynamic(itemAdapter, layout.spanCount)

        itemAdapter.apply {
            setItem(Item("Header 1", Item.VIEW_TYPE_HEADER))
            setItem(addItem(20))
            setItem(Item("Header 2", Item.VIEW_TYPE_HEADER))
            setItem(addItem(2))
            setItem(Item("Header 3", Item.VIEW_TYPE_HEADER))
            setItem(addItem(15))
            setItem(Item("Header 4", Item.VIEW_TYPE_HEADER))
            setItem(addItem(10))
            setItem(Item("Header 5", Item.VIEW_TYPE_HEADER))
            setItem(addItem(6))
        }
    }

    private fun addItem(count: Int) : MutableList<Item> {
        val item = mutableListOf<Item>()
        for (i in 0..count) {
            item.add(Item("", Item.VIEW_TYPE_ITEM))
        }
        return item
    }

    class AdapterSpanDynamic(private val adapter: Adapter, private val spanCount: Int) : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int =
            if (adapter.isHeader(position))
                spanCount
            else 1
    }
}
