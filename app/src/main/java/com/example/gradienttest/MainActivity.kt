package com.example.gradienttest

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(3000)
        animDrawable.start()

        rgThemes.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rbRoseanna -> changeTheme("#ffafbd", "#ffc3a0")
                R.id.rbPurpleLove -> changeTheme("#cc2b5e", "#753a88")
                R.id.rbMauve -> changeTheme("#42275a", "#734b6d")
                R.id.rbSexyBlue -> changeTheme("#2193b0", "#6dd5ed")
                R.id.rbFrost -> changeTheme("#000428", "#004e92")
            }
        }
    }

    // mao ni sya ang function nga mohimo sa gradient WITH ANIMATION.
    private fun changeTheme(firstColor: String, secondColor: String){
        val gradient1Drawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor(firstColor),
                Color.parseColor(secondColor),
                Color.parseColor(firstColor))
        )
        val gradient2Drawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor(secondColor),
                Color.parseColor(firstColor),
                Color.parseColor(firstColor))
        )
        val gradient3Drawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor(firstColor),
                Color.parseColor(firstColor),
                Color.parseColor(secondColor))
        )

        // mora ni syag maghimo kag gradient animation nga drawable. pero programmatically.
        val animaDrawable = AnimationDrawable()
        animaDrawable.addFrame(gradient1Drawable, 3000)
        animaDrawable.addFrame(gradient2Drawable, 3000)
        animaDrawable.addFrame(gradient3Drawable, 3000)


        // diri dapit iya iset ang animation as background
        root_layout.background = animaDrawable              // set background sa root_layout
        animaDrawable.setEnterFadeDuration(10)
        animaDrawable.setExitFadeDuration(3000)
        animaDrawable.start()
    }

}