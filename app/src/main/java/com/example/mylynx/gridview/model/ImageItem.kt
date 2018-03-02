package com.example.mylynx.gridview.model

import android.graphics.Bitmap



/**
 * Created by mylynx on 02.03.18.
 */
class ImageItem() {
    var image: String? = null
    var title: String? = null

    constructor(image: String?, title: String?): this() {
        this.image = image
        this.title = title
    }
}