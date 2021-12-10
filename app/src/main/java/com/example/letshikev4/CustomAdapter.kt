package com.example.letshikev4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val cardtitles = arrayOf("Cocora Valley Kike", "Tatacoa Dessert", "Bogota Hills", "Quitasol Hike", "Cocama Trail")
    val carddates = arrayOf("11/12/21", "28/12/21", "13/01/22", "20/01/22", "04/02/22")
    val cardimages = intArrayOf(R.drawable.im_cocorav, R.drawable.im_tatacoa, R.drawable.im_bogotahills, R.drawable.im_quitasol, R.drawable.im_pnarino)

    override fun onCreateViewHolder(parentA: ViewGroup, viewTypeA: Int): ViewHolder {
        val v = LayoutInflater.from (parentA.context).inflate(R.layout.event_card, parentA, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holderA: ViewHolder, positioni: Int) {
        holderA.itemTitle.text = cardtitles[positioni]
        holderA.itemDate.text = carddates[positioni]
        holderA.itemImage.setImageResource(cardimages[positioni])
    }

    override fun getItemCount(): Int {
        return cardtitles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDate: TextView

        init {
            itemImage = itemView.findViewById(R.id.event_image)
            itemTitle = itemView.findViewById(R.id.card_event_title)
            itemDate = itemView.findViewById(R.id.card_event_date)
        }
    }
}