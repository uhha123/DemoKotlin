package assignment.vn.kotlin.data

import assignment.vn.kotlin.model.RedditNewsItem
import rx.Observable

/**
 * Created by Ray on 6/1/17.
 */
class NewDataManager() {

    /**
     * private Observable<List<RedditNewsItem>> getNews(){}
     */

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            s ->
            val news = (1..10).map {
                RedditNewsItem("Author $it", "Title $it", it, 1457207701L - it * 200,
                        "http://lorempixel.com/200/200/technics/$it", "http://lorempixel.com/200/200/technics/$it")
            }
            s.onNext(news)
        }
    }
}