package com.arseniiptrv.basket.Controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arseniiptrv.basket.Model.Player
import com.arseniiptrv.basket.R
import com.arseniiptrv.basket.Utilities.EXTRA_PLAYER

import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)


        searchLeaguesText.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }
}
