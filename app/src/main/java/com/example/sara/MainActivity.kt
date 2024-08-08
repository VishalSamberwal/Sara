package com.example.sara

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.runBlocking
import com.google.ai.client.generativeai.GenerativeModel

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etprompt = findViewById<EditText>(R.id.etprompt)
        val submitbtn = findViewById<Button>(R.id.submit)
        val text = findViewById<TextView>(R.id.result)

        submitbtn.setOnClickListener{
          val prompt = etprompt.text.toString()
            val generativeModel = GenerativeModel(modelName = "gemini-pro", apiKey = "AIzaSyC8hvqAZjA3S5qAsfWD5U-q3X405ZA7_6c" )

            runBlocking{

                val response = generativeModel.generateContent(prompt)
                text.text= response.text

            }
        }



    }

}