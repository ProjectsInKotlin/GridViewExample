package com.example.mylynx.gridview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.example.mylynx.gridview.adapter.GridViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mylynx.gridview.model.ImageItem
import android.support.v4.content.res.TypedArrayUtils.getResourceId
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.R.array
import android.content.Intent
import android.content.res.TypedArray
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var adapter: GridViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = GridViewAdapter(this, R.layout.grid_item_layout, getData())
        gridViewId.adapter = adapter
        gridViewId.setOnItemClickListener({parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as ImageItem

            var intent = Intent(this,DetailsActivity::class.java)
            intent.putExtra("title", item.title);
            intent.putExtra("image", item.image);

            startActivity(intent)
        })



    }

    // Prepare some dummy data for gridview
    private fun getData(): ArrayList<ImageItem> {
        val imageItems = ArrayList<ImageItem>()
        val imgs = resources.getStringArray(R.array.image_ids)
        for (i in 0 until imgs.count()) {
            imageItems.add(ImageItem(imgs[i], "Image#" + i))
        }
        return imageItems
    }



}
