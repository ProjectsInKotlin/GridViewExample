package com.example.mylynx.gridview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var data = intent.extras

        if (data != null) {
            val title = data.getString("title")
            val bitmap = data.getString("image")

            titleId.text = title

            var idImage = this.resources.getIdentifier("com.example.mylynx.gridview:drawable/${bitmap}" ,null, null)
            imageId.setImageResource(idImage)
        }

    }
}
