package assignment.vn.kotlin.`interface`

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Ray on 5/29/17.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}