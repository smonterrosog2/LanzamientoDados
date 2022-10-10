package com.example.kotlindiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnLanzar)

        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice.
     */
    private fun rollDice() {

        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imgDado)
        diceImage.contentDescription = diceRoll.toString()
        setImage(diceRoll, diceImage)

        val dice2 = Dice(6)
        val diceRoll2 = dice.roll()
        val diceImage2: ImageView = findViewById(R.id.imgDado2)
        diceImage2.contentDescription = diceRoll.toString()
        setImage(diceRoll2, diceImage2)

    }

    /**
     * Update the screen with the result.
     */
    fun setImage(diceRoll: Int, diceImage: ImageView) {
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource as Int)
    }
}


class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}