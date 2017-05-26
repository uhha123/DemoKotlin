package assignment.vn.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import assignment.vn.kotlin.R
import assignment.vn.kotlin.model.Book
import com.bumptech.glide.Glide
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick

/**
 * Created by Ray on 5/26/17.
 */

class BookAdapter(var list: MutableList<Book>? = null, var context: Context? = null) :
        RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    interface ClickListener {
        fun clickListener(title: String? = null)
    }

    var listener: ClickListener? = null

    fun setClickListener(listener: ClickListener) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text = list?.get(position)?.title + " " + list?.get(position)?.id
        holder?.published?.text = list?.get(position)?.publishDate

        Glide.with(context).load(list?.get(position)?.imgUrl).into(holder?.image)
        holder?.itemView?.onClick {
            listener?.clickListener(list?.get(position)?.title + " " + list?.get(position)?.id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.find<ImageView>(R.id.imgView)
        var title: TextView = view.find <TextView>(R.id.title)
        var published: TextView = view.find <TextView>(R.id.published)

        init {

        }
    }
}