package assignment.vn.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import assignment.vn.kotlin.adapter.ListAdapter

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
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

        var list: MutableList<String>? = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15")
        list?.add("1235467")
        var adapter: ListAdapter = ListAdapter(list)
        rvDemo?.adapter = adapter
    }
}
