package com.arseniiptrv.basket.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arseniiptrv.basket.Model.Player
import com.arseniiptrv.basket.R
import com.arseniiptrv.basket.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view: View){
        if (player.skill != "") {
            val finishActivityIntent = Intent(this, FinishActivity::class.java)
            finishActivityIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivityIntent)
        } else {
            Toast.makeText(this, "Please choose your skill", Toast.LENGTH_SHORT).show()
        }

    }
}
