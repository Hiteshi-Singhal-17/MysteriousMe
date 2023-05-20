package com.example.mysteriousme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysteriousme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Flavia Augusta")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        // Set on click listener on done button
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * Displays the nickname in edit text view and hides the button and text view
     */
    private fun addNickname(view: View) {
        // Change the visibility of views
        binding.apply {
            // Two way binding since data source is changed, consequently view will also be changed
            myName?.nickname = nicknameEdit.text.toString()
            // To force a refresh and ensure changes made to data model or view properties
            // are immediately reflected in the UI
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE

        }

        // Hide the device software keyboard
        /* Get the system service responsible for managing the input methods. In this case, obtain
        the instance of the "Input Method Manager", which allows to control the behaviour of
        input method system */
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        /* Hide software keyboard from the screen
        view.windowToken -> get the reference of the visible area or screen where the UI is displayed
        0 or InputMethodManager.HIDE_IMPLICIT_ONLY -> Hide the keyboard if it was displayed implicitly. */
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}