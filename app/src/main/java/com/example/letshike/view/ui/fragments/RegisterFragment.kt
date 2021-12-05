package com.example.letshike.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation
import com.example.letshike.R


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // connection between register and homepage
        view.findViewById<Button>(R.id.register_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_homeFragment)
        }

        // connection back between register and login
        view.findViewById<ImageButton>(R.id.arrow_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}