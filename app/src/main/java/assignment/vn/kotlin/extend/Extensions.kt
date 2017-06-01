package assignment.vn.kotlin.extend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ray on 5/29/17.
 */
fun ViewGroup.inflate(layoutId: Int, attachRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachRoot)
}