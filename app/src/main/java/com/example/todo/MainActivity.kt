package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.view.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

   private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open) }
   private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_close) }

    private var clicked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
                onfabclick()
            }
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {

            val intent = Intent(this, todoactivity::class.java)
            startActivity(intent)
        }

        }
    private fun onfabclick() {
        setVisiblity(clicked)
        setAnimation(clicked)
        // setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisiblity(clicked: Boolean) {

        if (!clicked) {
            findViewById<FloatingActionButton>(R.id.floatingActionButton).visibility = View.VISIBLE
        } else {
            findViewById<FloatingActionButton>(R.id.floatingActionButton).visibility = View.INVISIBLE
        }

        }

    private fun setAnimation(clicked: Boolean) {

        if (!clicked) {
            findViewById<FloatingActionButton>(R.id.fab).startAnimation(rotateOpen)
        } else {
            findViewById<FloatingActionButton>(R.id.fab).startAnimation(rotateClose)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
