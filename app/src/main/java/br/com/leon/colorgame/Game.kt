package br.com.leon.colorgame

import android.graphics.Color
import kotlin.random.Random

class Game {
    companion object {
        val listOfColors = mutableListOf<Int>()
        val listOfTexts = mutableListOf<String>()

        fun createLists() {
            listOfColors.add(Color.RED)
            listOfColors.add(Color.GREEN)
            listOfColors.add(Color.YELLOW)
            listOfColors.add(Color.BLUE)

            listOfTexts.add("Vermelho")
            listOfTexts.add("Verde")
            listOfTexts.add("Amarelo")
            listOfTexts.add("Azul")
        }

        fun changeTextColor() : Int {
            return listOfColors[Random.nextInt(0, 4)]
        }

        fun changeText() : String {
            return listOfTexts[Random.nextInt(0, 4)]
        }

        fun compareColors(color: Int, name: String) : Boolean {
            if (color == Color.RED && name == "Vermelho") return true
            else if (color == Color.GREEN && name == "Verde") return true
            else if (color == Color.BLUE && name == "Azul") return true
            else if (color == Color.YELLOW && name == "Amarelo") return true

            return false
        }

        init {
            createLists()
        }
    }



}