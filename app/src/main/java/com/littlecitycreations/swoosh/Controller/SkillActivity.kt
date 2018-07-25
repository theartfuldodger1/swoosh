package com.littlecitycreations.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.littlecitycreations.swoosh.Utilities.EXTRA_LEAGUE
import com.littlecitycreations.swoosh.Utilities.EXTRA_SKILL
import com.littlecitycreations.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO $league")
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onSkillFinishClicked(view: View) {
        val finishActivity = Intent(this, FinishActivity::class.java)
        startActivity(finishActivity)

        if (skill != ""){
            val finishingActivity = Intent(this, FinishActivity::class.java)
            finishingActivity.putExtra(EXTRA_LEAGUE, league)
            finishingActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishingActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

}
