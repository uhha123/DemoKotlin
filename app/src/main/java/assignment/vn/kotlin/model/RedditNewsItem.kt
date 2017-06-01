package assignment.vn.kotlin.model

import assignment.vn.kotlin.`interface`.ViewType
import assignment.vn.kotlin.constant.AdapterConstants

/**
 * Created by Ray on 5/29/17.
 */
data class RedditNewsItem(val author: String = "",
                          val title: String = "",
                          val numComments: Int ,
                          val created: Long,
                          val thumb: String = "",
                          val url: String = "")
    : ViewType {
    override fun getViewType(): Int = AdapterConstants.NEWS
}