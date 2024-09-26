package com.example.marcadordetruco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0
    private lateinit var teamAScoreView: TextView
    private lateinit var teamBScoreView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamAScoreView = findViewById(R.id.teamA_score)
        teamBScoreView = findViewById(R.id.teamB_score)

        val incrementTeamA: Button = findViewById(R.id.increment_teamA)
        val decrementTeamA: Button = findViewById(R.id.decrement_teamA)
        val incrementTeamB: Button = findViewById(R.id.increment_teamB)
        val decrementTeamB: Button = findViewById(R.id.decrement_teamB)
        val resetButton: Button = findViewById(R.id.reset_button)

        incrementTeamA.setOnClickListener { updateScore("A", 1) }
        decrementTeamA.setOnClickListener { updateScore("A", -1) }
        incrementTeamB.setOnClickListener { updateScore("B", 1) }
        decrementTeamB.setOnClickListener { updateScore("B", -1) }
        resetButton.setOnClickListener { resetGame() }
    }

    private fun updateScore(team: String, points: Int) {
        if (team == "A") {
            scoreTeamA += points
            if (scoreTeamA >= 12) {
                Toast.makeText(this, "Time A venceu!", Toast.LENGTH_LONG).show()
                resetGame()
            } else if (scoreTeamA < 0) {
                scoreTeamA = 0
            }
            teamAScoreView.text = scoreTeamA.toString()
        } else {
            scoreTeamB += points
            if (scoreTeamB >= 12) {
                Toast.makeText(this, "Time B venceu!", Toast.LENGTH_LONG).show()
                resetGame()
            } else if (scoreTeamB < 0) {
                scoreTeamB = 0
            }
            teamBScoreView.text = scoreTeamB.toString()
        }
    }

    private fun resetGame() {
        scoreTeamA = 0
        scoreTeamB = 0
        teamAScoreView.text = "0"
        teamBScoreView.text = "0"
    }
}
