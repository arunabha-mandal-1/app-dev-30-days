package com.example.listviewandadapterstwo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context: Activity, private val arraylist: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.each_item, arraylist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.each_item, null)
        val image = view.findViewById<CircleImageView>(R.id.profilePic)
        val name = view.findViewById<TextView>(R.id.tvName)
        val lastMsg = view.findViewById<TextView>(R.id.tvLastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.lastMsgTime)

        name.text = arraylist[position].name
        lastMsg.text = arraylist[position].lastMsg
        lastMsgTime.text = arraylist[position].lastMsgTime
        image.setImageResource(arraylist[position].imageId)
        return view
    }
}