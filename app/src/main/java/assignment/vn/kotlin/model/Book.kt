package assignment.vn.kotlin.model

/**
 * Created by Ray on 5/26/17.
 */

class Book {
    var id = ""
    var title = ""
    var publishDate = ""
    var imgUrl = ""

    constructor(id: String, title: String, publishDate: String, imgUrl: String) {
        this.id = id
        this.title = title
        this.publishDate = publishDate
        this.imgUrl = imgUrl
    }


}