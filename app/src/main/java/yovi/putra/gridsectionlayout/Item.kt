package yovi.putra.gridsectionlayout

class Item (
    var title: String?,
    var type: Int = VIEW_TYPE_ITEM
) {
    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_HEADER = 1
    }
}
