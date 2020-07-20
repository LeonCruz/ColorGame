package br.com.leon.colorgame

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.leon.colorgame.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )
        binding.btnRed.setBackgroundColor(Color.RED)
        binding.btnBlue.setBackgroundColor(Color.BLUE)
        binding.btnGreen.setBackgroundColor(Color.GREEN)
        binding.btnYellow.setBackgroundColor(Color.YELLOW)

        changeValues()

        binding.btnRed.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnRed.text.toString())) updateScore() else gameOver()
            changeValues()
        }
        binding.btnYellow.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnYellow.text.toString())) updateScore() else gameOver()
            txtColor.setTextColor(Game.changeTextColor())
            txtColor
        }
        binding.btnGreen.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnGreen.text.toString())) updateScore() else gameOver()
            changeValues()
        }
        binding.btnBlue.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnBlue.text.toString())) updateScore() else gameOver()
            changeValues()
        }
        return binding.root
    }

    private fun changeValues() {
        binding.txtColor.setTextColor(Game.changeTextColor())
        binding.txtColor.text = Game.changeText()
    }

    private fun updateScore() {
        val value = binding.score.text.toString().toInt()
        binding.score.text = (value + 1).toString()
    }

    private fun gameOver() {
        score.text = "0"
        Toast.makeText(context, "Fim de jogo", Toast.LENGTH_LONG).show()
    }
}