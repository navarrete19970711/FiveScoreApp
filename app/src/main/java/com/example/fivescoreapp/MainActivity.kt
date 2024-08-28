package com.example.fivescoreapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1) viewを取得
        val tvScore:TextView = findViewById(R.id.tvScore)
        val btnMinus:Button = findViewById(R.id.btnMinus)
        val btnPlus:Button = findViewById(R.id.btnPlus)
        var num = 0

        // 2) +ボタンを押したら、１増える
        btnPlus.setOnClickListener {
            num++
            // 4) numが5になったらGameClear
            if (num == 5){
                val intent = Intent(this,GameClear::class.java)
                startActivity(intent)
                finish()
            }else{
                tvScore.text = num.toString()
            }

        }

        // 3) -ボタンを押したら、１減る
        btnMinus.setOnClickListener {
            num--
            // 5) numが-5になったらGameOver
            if (num == -5){
                val intent = Intent(this,GameOver::class.java)
                startActivity(intent)
                finish()
            }else{
                tvScore.text = num.toString()
            }

        }


    }
}