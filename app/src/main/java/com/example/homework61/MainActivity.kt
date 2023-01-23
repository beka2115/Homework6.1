package com.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val MAIN_KEY_INTENT = "Data"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var editIntent: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editIntent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val text =
                        result.data!!.getStringExtra(SecondActivity.SECOND_ACTIVITY_KEY_INTENT)
                    binding.editMain.setText(text)
                }
            }
        initClicker()
    }

    private fun initClicker(){
        binding.btnNext.setOnClickListener {
            editIntent.launch(
                Intent(this, SecondActivity::class.java).putExtra(
                    MAIN_KEY_INTENT,
                    binding.editMain.text.toString()
                )
            )
        }
    }
}