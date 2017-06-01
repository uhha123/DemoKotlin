package assignment.vn.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import assignment.vn.kotlin.adapter.BookAdapter
import assignment.vn.kotlin.adapter.ListAdapter
import assignment.vn.kotlin.adapter.NewsAdapter
import assignment.vn.kotlin.data.NewDataManager
import assignment.vn.kotlin.model.Book
import assignment.vn.kotlin.model.RedditNewsItem

import kotlinx.android.synthetic.main.activity_main.*
import rx.schedulers.Schedulers
import java.util.*

class ObjectActivity : AppCompatActivity(), BookAdapter.ClickListener {
    override fun clickListener(title: String?) {
        Toast.makeText(baseContext, title, Toast.LENGTH_SHORT).show()
    }

    private val rvList by lazy { rvDemo }
    private val newDataManager by lazy { NewDataManager() }

    var string: String? = "abc"
    var context: Context? = null
//    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        string = null

//        var textView = findViewById(R.id.textView) as TextVie
//        textView = null


        context = baseContext

        context?.let {
            string = context!!.resources.getString(R.string.demo)
            //More
        }

        textView?.text = string ?: "Hello Kotlin" // string == null ? "Hello Kotlin" : string

        initRecyclerView()
    }

    fun initRecyclerView() {
        rvList?.layoutManager = LinearLayoutManager(context)
        rvList?.setHasFixedSize(true)

//        listBook()

        /**
         * for (i in 1..10) {
         *      news.add(RedditNewsItem("Author $i", "Title $i", i, 1457207701L - i * 200,
         *      "http://lorempixel.com/200/200/technics/$i", "http://lorempixel.com/200/200/technics/$i"))
         * }
         */
//        val news = (1..10).map {
//            RedditNewsItem("Author $it", "Title $it", it, 1457207701L - it * 200,
//                    "http://lorempixel.com/200/200/technics/$it", "http://lorempixel.com/200/200/technics/$it")
//        }
//

        val adapter = NewsAdapter()
//        adapter.addNews(news)
        requestNewsData()

        rvList?.adapter = adapter

        var handler = Handler()
        handler.postDelayed({ requestNewsData() }, 5000)
    }

    fun requestNewsData() {
        val subscription = newDataManager.getNews()
                .subscribeOn(Schedulers.io())
                .subscribe({ newsData ->
                    (rvList?.adapter as NewsAdapter).addNews(newsData)
                }, {
                    e ->
                    e.printStackTrace()
                })
    }

    fun listBook() {
        var list: MutableList<Book> = mutableListOf()
        list.add(Book(1, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(2, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(3, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(4, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(5, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(6, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(7, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(8, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))
        list.add(Book(9, "Ca phe sang cung Tony Teo", "26/05/2017", "http://www.iconsfind.com/wp-content/uploads/2016/10/20161014_58006bfd76dcf.png"))

        var adapter: BookAdapter = BookAdapter(list, context)
        adapter?.setClickListener(this)
    }
}

