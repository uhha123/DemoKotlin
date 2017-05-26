package assignment.vn.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import assignment.vn.kotlin.adapter.BookAdapter
import assignment.vn.kotlin.adapter.ListAdapter
import assignment.vn.kotlin.model.Book

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ObjectActivity : AppCompatActivity(), BookAdapter.ClickListener {
    override fun clickListener(title: String?) {
        Toast.makeText(baseContext, title, Toast.LENGTH_SHORT).show()
    }

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
        }

        textView?.text = string ?: "Hello Kotlin" // string == null ? "Hello Kotlin" : string

        initRecyclerView()
    }

    fun initRecyclerView() {
        rvDemo?.layoutManager = LinearLayoutManager(context)
        rvDemo?.setHasFixedSize(true)

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
        rvDemo?.adapter = adapter
    }
}