package assignment.vn.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import assignment.vn.kotlin.R
import assignment.vn.kotlin.`interface`.ViewType
import assignment.vn.kotlin.`interface`.ViewTypeDelegateAdapter
import assignment.vn.kotlin.extend.inflate
import assignment.vn.kotlin.model.RedditNewsItem
import assignment.vn.kotlin.util.getFriendlyTime
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_book.view.*
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by Ray on 5/29/17.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            Glide.with(context).load(item.url).into(img_thumbnail)
            title?.text = item?.title ?: ""
            description?.text = item?.title ?: ""
            author?.text = item?.author ?: ""
            time?.text = item.created.getFriendlyTime()
            comments?.text = "${item.numComments} comments"
        }
    }
}