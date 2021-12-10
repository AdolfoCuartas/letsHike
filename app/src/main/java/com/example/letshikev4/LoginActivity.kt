package com.example.letshikev4

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // in order to see the splash screen a little bit longer, i added Thread.sleep
        Thread.sleep(2000)

        // as we are loading the splashscreen theme first on the manifest, we have too switch to the app theme
        setTheme(R.style.Theme_LetsHikeV4)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //setup
        setup()
    }

    private fun setup(){

        register_button.setOnClickListener {
            if (login_email_input.text.isNotEmpty() && login_password_input.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    login_email_input.text.toString(),
                    login_password_input.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showProfile(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else {
                            showAlert()
                        }
                }
            }
        }

        access_button.setOnClickListener {
            if (login_email_input.text.isNotEmpty() && login_password_input.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    login_email_input.text.toString(),
                    login_password_input.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showProfile(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else {
                        showAlert()
                    }
                }
            }
        }

    }

    private fun showProfile(email: String, provider: ProviderType){
        val profileIntent = Intent(this, ProfileActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(profileIntent)
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}