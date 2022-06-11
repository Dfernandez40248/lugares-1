package com.example.lugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.lugares.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    // conexion con firebase
    private lateinit var auth: FirebaseAuth
    //conexion parte visual y logica
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //INICIALIZAR FIREBASE
    FirebaseApp.initializeApp(this)
    auth = Firebase.auth

    //ASIGNAR METODOS A BOTONES
        binding.btlogin.setOnClickListener{
            login()
        }

        binding.btRegister.setOnClickListener{
            register()
        }

    }

    private fun register() {
        val email = binding.txtEmail.text.toString()
        val password = binding.txtPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                Log.d("User Register", "Success")
            }else{
                Log.d("User Register", "Fail")
                Toast.makeText(baseContext,"Register Fail",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun login() {
        val email = binding.txtEmail.text.toString()
        val password = binding.txtPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                val user = auth.currentUser
                Log.d("User login", "Success")
            }else{
                Log.d("User login", "Fail")
                Toast.makeText(baseContext,"Login Fail",Toast.LENGTH_LONG).show()
            }
        }
    }

}