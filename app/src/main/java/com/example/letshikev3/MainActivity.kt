package com.example.letshikev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.letshikev3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // recordar hacer esto en modo binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ubicacion del bottomNavigation
        // creamos una constante que se llame bottomNavigationView y a traves del binding invocamos el id del bottomNavigationView
        val bottomNavigationView = binding.bottomNavigationBar

        // creamos una constante para el navHost e invocamos el supportFragmentManager
        // buscamos por id (el del contenedor de fragmentos)
        // reocrdar que estamos utilizando un FragmentContainerView
        // toco importar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        // luego ubicamos al nav controller, creamos una constante y ubicamos el navController a traves del navHostFragment
        val navController = navHostFragment.navController

        // ahora toca hacer la sincronizacion del navHostFragment con el navController para asignar las escuchas correspondientes
        // a traves de la constante bottomNavigationView invocamoes el setupWithNavController
        // y le pasamos la constante navController
        bottomNavigationView.setupWithNavController(navController)

        // ----------------------------------- recycler -----------------------------------

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_cards)
        val adapter = CustomAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


}