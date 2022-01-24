package com.example.basededatossql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.basededatossql.RoomApp.Companion.db
import com.example.basededatossql.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val amigosDBHelper = MySQLiteHelper(this)

        binding.btnMostrar.setOnClickListener {
            actualizarDatos()
        }

        binding.btnGuardar.setOnClickListener {
            if (binding.etNombre.text.isNotEmpty() && binding.etEmail.text.isNotEmpty()) {
                lifecycleScope.launch {
                    db.misAmigosDao().insertar(MisAmigos(
                        nombre = binding.etNombre.text.toString(),
                        email = binding.etEmail.text.toString()
                    ))
                    actualizarDatos()
                }
            } else {
                Toast.makeText(this, "Rellena todos los campos primero", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnActualizar.setOnClickListener {
            if ((binding.etIdActualizar.text.isNotEmpty() && binding.etNombreActualizar.text.isNotEmpty()) ||
                (binding.etIdActualizar.text.isNotEmpty() && binding.etEmailActualizar.text.isNotEmpty())) {

                var id = binding.etIdActualizar.text.toString().toInt()
                var nombre = binding.etNombreActualizar.text.toString()
                var email = binding.etEmailActualizar.text.toString()

                lifecycleScope.launch {
                    db.misAmigosDao().update(
                        id,nombre,email
                    )
                    actualizarDatos()
                }
            } else {
                Toast.makeText(this,"Rellena el campo ID y alguno de los dos por lo menos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEliminar.setOnClickListener {
            if (binding.etIdBorrar.text.isNotEmpty()) {
                var id = binding.etIdBorrar.text.toString().toInt()
                lifecycleScope.launch {
                    db.misAmigosDao().delete(id)
                    actualizarDatos()
                }
            } else {
                Toast.makeText(this,"Rellena el campo primero", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun actualizarDatos() {
        lifecycleScope.launch {
            val todos = db.misAmigosDao().getTodo()
            binding.recyclerView.adapter = AmigosAdapter(this@MainActivity, todos)
        }
    }
}