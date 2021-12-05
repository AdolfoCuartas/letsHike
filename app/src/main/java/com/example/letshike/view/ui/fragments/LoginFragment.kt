package com.example.letshike.view.ui.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.letshike.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        // connection between login and homepage
        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        }

        // connection between login and register page
        view.findViewById<TextView>(R.id.register_link).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}