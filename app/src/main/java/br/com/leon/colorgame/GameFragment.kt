package br.com.leon.colorgame

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import br.com.leon.colorgame.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var i: Int = 3
    private lateinit var countDownTimer: CountDownTimer

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
        time()

        binding.btnRed.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnRed.text.toString())) {
                updateScore()
                countDownTimer.cancel()
                binding.timer.visibility = View.GONE
                time()
            }
            else { gameOver() }

            changeValues()
        }
        binding.btnYellow.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnYellow.text.toString())) {
                updateScore()
                countDownTimer.cancel()
                binding.timer.visibility = View.GONE
                time()
            }
            else { gameOver() }

            changeValues()
        }
        binding.btnGreen.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnGreen.text.toString())) {
                updateScore()
                countDownTimer.cancel()
                binding.timer.visibility = View.GONE
                time()
            }
            else { gameOver() }

            changeValues()
        }
        binding.btnBlue.setOnClickListener {
            if (Game.compareColors(txtColor.currentTextColor, btnBlue.text.toString())) {
                updateScore()
                countDownTimer.cancel()
                binding.timer.visibility = View.GONE
                time()
            }
            else { gameOver() }

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

    private fun time() {
        binding.timer.visibility = View.VISIBLE

        countDownTimer = object: CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                binding.timer.visibility = View.GONE
                gameOver()
            }
        }
        countDownTimer.start()
    }

    private fun gameOver() {
        countDownTimer.cancel()
        binding.timer.visibility = View.GONE
        score.text = "0"
        view?.findNavController()?.navigate(R.id.action_gameFragment_to_gameOverFragment)
    }
}