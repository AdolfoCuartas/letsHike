package com.example.letshikev3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// este custom adapter es el que va a poblar las cartas con informacion
// el viewHolder va a dar en rojo ya que hay que crear algunos metodos y la clase del viewHolder

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    // aca declaramos constantes que son arreglos con la informacion que vamos a mostrar
    // osea la lista de los titulos, las fechas y las imagenes
    val cardtitles = arrayOf("Cocora Valley Kike", "Tatacoa Dessert", "Bogota Hills", "Quitasol Hike", "Cocama Trail")
    val carddates = arrayOf("11/12/21", "28/12/21", "13/01/22", "20/01/22", "04/02/22")
    val cardimages = intArrayOf(R.drawable.im_cocorav, R.drawable.im_tatacoa, R.drawable.im_bogotahills, R.drawable.im_quitasol, R.drawable.im_pnarino )


    // hay que crear el metodo onCreateViewHolder
    // este es el metodo justo cuando entra por primera vez a crear el recycler view
    override fun onCreateViewHolder(parentA: ViewGroup, viewTypeA: Int): ViewHolder {

        // declaramos una constante para poblar con un layout especifico
        // notar que hacemos referencia al nombre del layout (R.layout.), en este caso fragment_cards
        // y le agregamos el parentA que lo creamos como parametro
        val v = LayoutInflater.from (parentA.context).inflate(R.layout.card_layout, parentA, false)
        return ViewHolder(v)
    }

    // este metod se crea cuando ya haya poblado cada elemento separado del recycler view
    // en los parentesis en el tutorial cambia: (holder: ViewHolder, position: Int) por: (holderA: ViewHolder, positionA: Int)
    // esta funcion pide un holderA de tipo ViewHolder y una positioni de tipo Int
    // entonces le pasamos las variables que creamos en la clase ViewHolder mas abajo
    override fun onBindViewHolder(holderA: ViewHolder, positioni: Int) {
        holderA.itemTitle.text = cardtitles[positioni]
        holderA.itemDate.text = carddates[positioni]
        holderA.itemImage.setImageResource(cardimages[positioni])
    }

    // este metodo tiene el tamano del arreglo
    override fun getItemCount(): Int {
        return cardtitles.size

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        // aca se crean las variables referentes a los tipos de datos que tienen las cartas
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDate: TextView

        // a continuacion vamos a enlazar cada una de estas variables con los id del cardView
        init {
            itemImage = itemView.findViewById(R.id.event_image)
            itemTitle = itemView.findViewById(R.id.card_event_title)
            itemDate = itemView.findViewById(R.id.card_event_date)
        }
    }
}