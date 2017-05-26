package assignment.vn.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import assignment.vn.kotlin.R
import org.jetbrains.anko.find

/**
 * Created by Ray on 5/26/17.
 */

class ListAdapter(var list: MutableList<String>? = null) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text = list?.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.find <TextView>(R.id.textView)

        init {

        }
    }
}