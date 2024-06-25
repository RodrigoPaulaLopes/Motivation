package com.rodrigo.myapplicationm

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigo.myapplicationm.databinding.ActivityMainBinding
import com.rodrigo.myapplicationm.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(component: View) {
        if (component.id == R.id.button_save){
            save()
        }
    }

    fun save(){

        val security: SharedPreferences = this.getSharedPreferences("security", MODE_PRIVATE)
        val name = binding.editTextLetsBegin.text.toString()

        if(name == ""){
            Toast.makeText(this, "Precisa digitar seu nome!", Toast.LENGTH_SHORT).show()
        }else{
            saveContext("name", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    fun saveContext(key: String, value: String) {
        val session: Session = Session(this)
        session.storeString(key, value)
    }
}