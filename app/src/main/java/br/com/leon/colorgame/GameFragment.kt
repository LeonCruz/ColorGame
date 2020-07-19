package br.com.leon.colorgame

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_game.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        btnRed.setBackgroundColor(Color.RED)
        btnBlue.setBackgroundColor(Color.BLUE)
        btnGreen.setBackgroundColor(Color.GREEN)
        btnYellow.setBackgroundColor(Color.YELLOW)

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
        return inflater.inflate(R.layout.fragment_game, container, false)
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
        Toast.makeText(context, "Fim de jogo", Toast.LENGTH_LONG).show()
    }
}