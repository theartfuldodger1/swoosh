package com.littlecitycreations.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.littlecitycreations.swoosh.Model.Player
import com.littlecitycreations.swoosh.Utilities.EXTRA_PLAYER
import com.littlecitycreations.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getStringExtra(EXTRA_PLAYER)
        println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO $player.league")
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillFinishClicked(view: View) {
        val finishActivity = Intent(this, FinishActivity::class.java)
        startActivity(finishActivity)

        if (player.skill != ""){
            val finishingActivity = Intent(this, FinishActivity::class.java)
            finishingActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishingActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

}
