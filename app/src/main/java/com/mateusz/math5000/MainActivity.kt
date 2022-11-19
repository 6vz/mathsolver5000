package com.mateusz.math5000

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        fun checkPoint() {
            val pointsDisplay = findViewById<TextView>(R.id.points)
            val points = pointsDisplay.text.toString().toInt()
            if (points >= 100) {
                val builder = android.app.AlertDialog.Builder(this)
                builder.setCancelable(false)
                builder.setTitle("You have reached the limit")
                builder.setMessage("Wow! You definitely have a lot of time on your hands. You can't get any more points - this is hard limit set by a developer. You can reset the points by pressing the reset button.")
                builder.setPositiveButton("Start Again") { dialog, which ->
                    pointsDisplay.text = "0"
                }
                builder.setNegativeButton("Leave the App") { dialog, which ->
                    finish()
                }
                builder.show()
            } else if (points <= -10) {
                val builder = android.app.AlertDialog.Builder(this)
                builder.setCancelable(false)
                builder.setTitle("Wow! You're that dumb?")
                builder.setMessage("If you cannot do this, you should probably go to school, and learn how to do basic math. Please leave the app, there is no chance for you")
                builder.setPositiveButton("Leave the App") { dialog, which ->
                    finish()
                }
                builder.setNegativeButton("Leave the App") { dialog, which ->
                    finish()
                }
                builder.show()
            }
        }
        fun addPoint() {
            val point = findViewById<TextView>(R.id.points)
            val points = point.text.toString().toInt()
            point.text = (points + 1).toString()
        }
        fun reducePoint() {
            val point = findViewById<TextView>(R.id.points)
            val points = point.text.toString().toInt()
            point.text = (points - 1).toString()
        }

        fun clearInput() {
            findViewById<EditText>(R.id.answer).text.clear()
        }

        fun newTask() {
            val taskAssigner = (1..3).random()
            val a = (1..25).random()
            val b = (1..25).random()
            if (taskAssigner == 1) {
                val format = "$a + $b"
                findViewById<TextView>(R.id.task).text = format
                findViewById<Button>(R.id.submit).setOnClickListener {
                    val answer = findViewById<TextView>(R.id.answer).text.toString().toInt()
                    val a_answer = answer.toString()
                    // if a_answer is empty
                    if (answer == a + b) {
                        clearInput()
                        addPoint()
                        checkPoint()
                        newTask()
                    } else {
                        clearInput()
                        reducePoint()
                        checkPoint()
                        newTask()
                    }
                }
            } else if (taskAssigner == 2) {
                val format = "$a - $b"
                findViewById<TextView>(R.id.task).text = format
                findViewById<Button>(R.id.submit).setOnClickListener {
                    val answer = findViewById<TextView>(R.id.answer).text.toString().toInt()
                    if (answer == a - b) {
                        println("valid")
                        clearInput()
                        addPoint()
                        checkPoint()
                        newTask()
                    } else {
                        println("invalid")
                        clearInput()
                        reducePoint()
                        checkPoint()
                        newTask()
                    }
                }
            } else if (taskAssigner == 3) {
                val format = "$a * $b"
                findViewById<TextView>(R.id.task).text = format
                findViewById<Button>(R.id.submit).setOnClickListener {
                    val answer = findViewById<TextView>(R.id.answer).text.toString().toInt()
                    if (answer == a * b) {
                        println("valid")
                        clearInput()
                        addPoint()
                        checkPoint()
                        newTask()
                    } else {
                        println("invalid")
                        clearInput()
                        reducePoint()
                        checkPoint()
                        newTask()
                    }
                }
            }
        }

        findViewById<ImageView>(R.id.logo).setOnClickListener {
            val builder = android.app.AlertDialog.Builder(this)
            val input = EditText(this)
            builder.setView(input)
            builder.setCancelable(false)
            builder.setTitle("OWO! What's this?")
            builder.setMessage("You discovered SECRET ADMIN MODE(tm). It's mainly used for developing purposes. It's some sort of a cheat code, like in GTA. If you need to reset task urugently type taskReset (with keeping capitalisation - THIS IS IMPORTANT)")
            builder.setPositiveButton("OK") { dialog, which ->
                val value = input.text.toString()
                if (value == "PAINKILLER" || value == "TOOLUP" || value == "TURTLE" || value == "ROCKET" || value == "COMET" || value == "GOTGILLS" || value == "BUZZOFF" || value == "SKYDIVE" || value == "LAWYERUP" || value == "DEADEYE" || value == "POWERUP" || value == "CATCHME" || value == "FUGITIVE" || value == "HOTHANDS" || value == "HIGHEX" || value == "INCENDIARY" || value == "LIQUOR" || value == "SKYFALL" || value == "MAKEITRAIN" || value == "SNOWDAY" || value == "FLOATER" || value == "SLOWMO" || value == "TRASHED" || value == "BARNSTORM" || value == "BANDIT" || value == "FLYSPRAY" || value == "HOLEIN1" || value == "RAPIDGT" || value == "VINEWOOD" || value == "OFFROAD") {
                    val builder_gta = android.app.AlertDialog.Builder(this)
                    builder_gta.setCancelable(false)
                    builder_gta.setTitle("what the fuck man?")
                    builder_gta.setMessage("you just entered a cheat code from GTA V. you're a fucking idiot.")
                    builder_gta.setPositiveButton("pls get a life") { dialog, which ->
                        finish()
                    }
                    builder_gta.show()
                } else if (value == "func_task_reset") {
                    newTask()
                    reducePoint()
                    checkPoint()
                    val taskModifiedModal = android.app.AlertDialog.Builder(this)
                    taskModifiedModal.setCancelable(false)
                    taskModifiedModal.setMessage("Task has been changed. By that, we have reduced one point from your score to ensure that you're not cheating.")
                    taskModifiedModal.setPositiveButton("cope with it") { dialog, which ->
                        // do nothing
                    }
                    taskModifiedModal.setNegativeButton("cry about it") { dialog, which ->
                        finish()
                    }
                    taskModifiedModal.show()
                } else if (value == "func_points_add") {
                    val point = findViewById<TextView>(R.id.points)
                    val points = point.text.toString().toInt()
                    point.text = (points + 10).toString()
                    val builder = android.app.AlertDialog.Builder(this)
                    builder.setCancelable(false)
                    builder.setTitle("Points added")
                    builder.setMessage("10 points have been added to your score.")
                    builder.setPositiveButton("ok") { dialog, which ->
                        // do nothing
                    }
                    builder.show()
                } else if (value == "func_points_reduce") {
                    val point = findViewById<TextView>(R.id.points)
                    val points = point.text.toString().toInt()
                    point.text = (points - 10).toString()
                    val builder = android.app.AlertDialog.Builder(this)
                    builder.setCancelable(false)
                    builder.setTitle("Points removed")
                    builder.setMessage("10 points have been removed to your score.")
                    builder.setPositiveButton("ok") { dialog, which ->
                        // do nothing
                    }
                    builder.show()
                } else if (value == "func_points_set") {
                    val point = findViewById<TextView>(R.id.points)
                    val builder_set = android.app.AlertDialog.Builder(this)
                    val input_set = EditText(this)
                    builder_set.setView(input_set)
                    builder_set.setCancelable(false)
                    builder_set.setTitle("Set points")
                    builder_set.setMessage("Enter the amount of points you want to set. This will override your current score.")
                    builder_set.setPositiveButton("submit") { dialog, which ->
                        val value_set = input_set.text.toString().toInt()
                        point.text = value_set.toString()
                        val builder_set_confirm = android.app.AlertDialog.Builder(this)
                        builder_set_confirm.setCancelable(false)
                        builder_set_confirm.setTitle("Points set")
                        builder_set_confirm.setMessage("Your score has been set to $value_set points.")
                        builder_set_confirm.setPositiveButton("ok") { dialog, which ->
                            // do nothing
                        }
                        builder_set_confirm.show()

                    }
                    builder_set.show()
                } else if (value == "func_points_reset") {
                    val builder_confirm = android.app.AlertDialog.Builder(this)
                    builder_confirm.setCancelable(false)
                    builder_confirm.setTitle("Reset points")
                    builder_confirm.setMessage("Are you sure you want to reset your score? This action cannot be undone, since i like using big words i will tell it again. THIS ACTION IS IREVERSIBLE.")
                    builder_confirm.setPositiveButton("reset my score") { dialog, which ->
                        val point = findViewById<TextView>(R.id.points)
                        point.text = "0"
                        val builder_reset = android.app.AlertDialog.Builder(this)
                        builder_reset.setCancelable(false)
                        builder_reset.setTitle("Points reset")
                        builder_reset.setMessage("Your score has been reset to 0 points.")
                        builder_reset.setPositiveButton("ok") { dialog, which ->
                            // do nothing
                        }
                        builder_reset.show()
                    }
                    builder_confirm.setNegativeButton("changed my mind") { dialog, which ->
                        // do nothing
                    }
                    builder_confirm.show()
                } else {
                    val builder22 = android.app.AlertDialog.Builder(this)
                    builder22.setTitle("Invalid Code")
                    builder22.setMessage("Provided code doesn't exists")
                    builder22.setPositiveButton("Ignore & Leave Admin Mode") { dialog, which ->
                        // do nothing
                    }
                    builder22.show()
                }
            }
            builder.show()
        }

        newTask()
        }
}