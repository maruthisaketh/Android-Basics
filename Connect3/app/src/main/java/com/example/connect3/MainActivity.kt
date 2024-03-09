package com.example.connect3


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // true = yellow player, false is red player
    private var activePlayer = true

    //Array of integers to track the game state
    //0 = empty State.
    //1 = Yellow State
    //2 = Red State
    private var gameState = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    //Array of positions for winning game
    private val winningPositions = arrayOf(
        arrayOf(0, 1, 2),
        arrayOf(3, 4, 5),
        arrayOf(6, 7, 8),
        arrayOf(0, 3, 6),
        arrayOf(1, 4, 7),
        arrayOf(2, 5, 8),
        arrayOf(0, 4, 8),
        arrayOf(2, 4, 6)
    )

    //Check if game is active
    private var gameActive = true

    fun dropIn(view: View) {

        val counter = findViewById<ImageView>(view.id)
        val tag = counter.tag.toString().toInt()

        if ((gameState[tag] == 0) and gameActive) {
            counter.translationY = -1500F

            activePlayer = if (activePlayer) {
                counter.setImageResource(R.drawable.yellow)
                gameState[tag] = 1
                false
            } else {
                counter.setImageResource(R.drawable.red)
                gameState[tag] = 2
                true
            }

            for (positions in winningPositions) {
                if ((gameState[positions[0]] == gameState[positions[1]]) and (gameState[positions[0]] == gameState[positions[2]])) {
                    if (gameState[positions[0]] != 0) {
                        val winnerText = findViewById<TextView>(R.id.winnerTextView)
                        if (activePlayer) {
                            winnerText.text = getString(R.string.red_has_won)
                        } else {
                            winnerText.text = getString(R.string.yellow_has_won)
                        }
                        gameActive = false
                        winnerText.visibility = View.VISIBLE
                        val button = findViewById<Button>(R.id.playAgainButton)
                        button.visibility = View.VISIBLE
                        button.isClickable = true
                    }
                }
            }

            counter.animate().translationY(0F).setDuration(400)
        }
    }

    fun resetGame(view: View) {
        val winnerText = findViewById<TextView>(R.id.winnerTextView)
        val button = findViewById<Button>(R.id.playAgainButton)
        winnerText.visibility = View.INVISIBLE
        gameState = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        button.visibility = View.INVISIBLE
        button.isClickable = false

        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        for (i in 0..<gridLayout.childCount) {
            val imageView = findViewById<ImageView>(gridLayout.getChildAt(i).id)
            imageView.setImageDrawable(null)
        }

        activePlayer = true
        gameActive = true

    }
}