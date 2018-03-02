package com.example.mylynx.gridview.adapter

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.TextView

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mylynx.gridview.R
import com.example.mylynx.gridview.model.ImageItem
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.grid_item_layout.view.*


/**
 * Created by mylynx on 02.03.18.
 */
class GridViewAdapter(private val ctx: Context, private val layoutResourceId: Int, private var data: ArrayList<ImageItem>) : ArrayAdapter<ImageItem>(ctx, layoutResourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row: View? = convertView //for 'recycling' item purpose

        var holder: ViewHolder

        if (row == null) {
            val inflater = (context as Activity).layoutInflater
            row = inflater.inflate(layoutResourceId, parent, false)
            //  var itemView = LayoutInflater.from(ctx).inflate(layoutResourceId, parent, false)
            holder = ViewHolder()
            holder.imageTitle = row!!.findViewById(R.id.text)
            holder.image = row.findViewById<ImageView>(R.id.image)
            row.tag = holder
        } else {
            holder = row.tag as ViewHolder
        }

        val item = data[position]
        holder.imageTitle!!.text = item.title
        var idImage = ctx.resources.getIdentifier("com.example.mylynx.gridview:drawable/${item.image}" ,null, null)
        holder.image!!.setImageResource(idImage)

        return row
    }

    internal class ViewHolder {
        var imageTitle: TextView? = null
        var image: ImageView? = null
    }







}