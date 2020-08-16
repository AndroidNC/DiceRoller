package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    lateinit var diceText1: TextView
    lateinit var diceText2: TextView
    lateinit var messageText: TextView
    lateinit var scoreText: TextView


    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"

        val resetButton : Button = findViewById(R.id.reset_button)


        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        diceText1 = findViewById(R.id.dice1_text)
        diceText2 = findViewById(R.id.dice2_text)

        messageText = findViewById(R.id.message_text)
        scoreText = findViewById(R.id.score_text)


        rollButton.setOnClickListener {
            rollDice()
        }

        resetButton.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        score = 0
        diceText1.text = ""
        diceText2.text = ""

        messageText.text = ""
        scoreText.text = ""

        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)

    }

    private fun rollDice() {
        messageText.text = "You rolled"

        val randomNumber1 = Random().nextInt(6) + 1
        val randomNumber2 = Random().nextInt(6) + 1

        score = score + randomNumber1 + randomNumber2

        diceText1.text = randomNumber1.toString()
        diceText2.text = randomNumber2.toString()

        val drawableResource1 = when (randomNumber1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (randomNumber2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        scoreText.text = "Score: ${score}"

    }
}