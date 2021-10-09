package com.example.test1application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1application.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var title: TitleFragment
    private var value: String? = ""
    private var value2: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        value = intent.getStringExtra("VALUE")
        value2 = intent.getStringExtra("VALUE2")

        binding.textView.setText(value)
        binding.textView2.setText(value2)

        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.titleFragment, title)
            commit()
        }


    }

    override fun onResume() {
        super.onResume()
        title.setTitle("結果です")
    }
}