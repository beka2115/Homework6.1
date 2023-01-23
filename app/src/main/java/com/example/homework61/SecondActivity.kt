package com.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object{
        const val SECOND_ACTIVITY_KEY_INTENT= "text"
    }
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra(MainActivity.MAIN_KEY_INTENT)
        binding.editSecond.setText(data)
        binding.btnBack.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra(SECOND_ACTIVITY_KEY_INTENT, binding.editSecond.text.toString()))
            finish()
        }
    }
}
