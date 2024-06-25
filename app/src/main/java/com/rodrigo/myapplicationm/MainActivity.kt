package com.rodrigo.myapplicationm

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigo.myapplicationm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNewFrase.setOnClickListener(this)

        findName()

    }

    override fun onClick(component: View) {
        if (component.id == R.id.button_new_frase){
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        }
    }

    fun findName(){
        binding.textName.text = "Bem vindo, ${Session(this).getString("name")}"
    }
}