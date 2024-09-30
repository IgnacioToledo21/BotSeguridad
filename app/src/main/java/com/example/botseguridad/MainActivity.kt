package com.example.botseguridad

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    object datosPropietario {
        const val NAME:String = "Juan"
    }

    object datosUsuario {
        const val NAME:String = "Juan"
        const val AGE:Int = 25
        val HOBBIES:List<String> = listOf("Surf", "Programacion", "Fútbol")

    }

    object etLog {
        const val TAG: String = ":!:!:!TAG"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val person: Persona = Persona("Juan", 25, listOf("Surf", "Programacion", "Fútbol"))
        botDeSeguridad(person)

        }

        private fun botDeSeguridad(person: Persona) {
            if(person.name == "Juan"){
                when (person.age) {
                    in 0..17 -> Log.d(":!:!:!TAG", "No puedes entrar, eres menor de edad")
                    in 65..100 -> Log.d(":!:!:!TAG", "No puedes entrar, eres demasiado mayor de edad")
                    in 18..64 -> Log.d(":!:!:!TAG", "Acceso autorizado, sus hobbies son: " + person.hobbies.toString())
                    else -> Log.d(":!:!:!TAG", "No puedes entrar, edad erronea.")
                }
            } else {
                Log.d(":!:!:!TAG", "Error al iniciar sesión. No es un usuario del sistema.")
            }
        }
    }

    data class Persona(
        val name: String,
        val age: Int,
        val hobbies: List<String>
    )
