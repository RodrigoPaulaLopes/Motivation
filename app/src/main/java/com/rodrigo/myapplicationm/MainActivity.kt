package com.rodrigo.myapplicationm

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigo.myapplicationm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding :ActivityMainBinding
    private var categoryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNewFrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageInfinite.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

        findName()

    }

    override fun onClick(component: View) {
        if (component.id == R.id.button_new_frase){
            categoryId = Motivation.filter.ALL
            setFrase()
        }

        if (component.id in listOf(R.id.image_all, R.id.image_infinite, R.id.image_sunny)){
            setImageColors(component.id)
        }
    }

    fun setImageColors(id: Int){
        binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))


        if (id == R.id.image_all){
            binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = Motivation.filter.ALL
        }
        if (id == R.id.image_sunny){
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = Motivation.filter.SUNNY
        }
        if (id == R.id.image_infinite){
            binding.imageInfinite.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = Motivation.filter.INFINITE
        }

        setFrase()
    }

    fun setFrase() : Unit{
        binding.textMotivation.text = Data().getRandomFrase(categoryId)
    }
    fun findName(){
        binding.textName.text = "Bem vindo, ${Session(this).getString("name")}"
    }
}