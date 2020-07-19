package br.com.leon.colorgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRed.setBackgroundColor(Color.RED)
        btnBlue.setBackgroundColor(Color.BLUE)
        btnGreen.setBackgroundColor(Color.GREEN)
        btnYellow.setBackgroundColor(Color.YELLOW)

        changeValues()

        btnRed.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnRed.text.toString())) updateScore() else gameOver()
            changeValues()
        }
        btnYellow.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnYellow.text.toString())) updateScore() else gameOver()
            txtColor.setTextColor(Game.changeTextColor())
            txtColor
        }
        btnGreen.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnGreen.text.toString())) updateScore() else gameOver()
            changeValues()
        }
        btnBlue.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnBlue.text.toString())) updateScore() else gameOver()
            changeValues()
        }

    }

    private fun changeValues() {
        txtColor.setTextColor(Game.changeTextColor())
        txtColor.text = Game.changeText()
    }

    private fun updateScore() {
        val value = score.text.toString().toInt()
        score.text = (value + 1).toString()
    }

    private fun gameOver() {
        score.text = "0"
        Toast.makeText(this, "Fim de jogo", Toast.LENGTH_LONG).show()
    }
}