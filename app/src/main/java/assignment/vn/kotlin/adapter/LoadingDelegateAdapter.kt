package assignment.vn.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import assignment.vn.kotlin.R
import assignment.vn.kotlin.`interface`.ViewType
import assignment.vn.kotlin.`interface`.ViewTypeDelegateAdapter
import assignment.vn.kotlin.extend.inflate

/**
 * Created by Ray on 5/29/17.
 */

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
//    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
//        return TurnsViewHolder(parent)
//    }

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {

    }

}