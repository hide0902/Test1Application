package com.example.test1application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.test1application.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private var value: String = ""
//    private var value2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val valu = pref.getString("VALU", "")
        val valu2 = pref.getString("VALU2", "")

        binding.textView3.setText(valu)
        binding.textView4.setText(valu2)
        binding.button.setOnClickListener {
            saveTap()
//            value = binding.textIn.text.toString()
//            value2 = binding.textIn2.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("VALUE", valu)
            intent.putExtra("VALUE2", valu2)
            startActivity(intent)

        }
    }
    private fun saveTap() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("VALU", binding.textIn.text.toString())
            putString("VALU2", binding.textIn2.text.toString())
        }
    }
}