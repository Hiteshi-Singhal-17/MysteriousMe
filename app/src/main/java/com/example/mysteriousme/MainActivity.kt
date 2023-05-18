package com.example.mysteriousme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get the reference of done button
        val doneButton = findViewById<Button>(R.id.done_button)
        // Set on click listener on done button
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * Displays the nickname in edit text view and hides the button and text view
     */
    private fun addNickname(view: View) {
        // Get the reference of nickname edit and text view
        val nicknameEdit = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        // Set the text of nickname text view
        nicknameText.text = nicknameEdit.text

        // Change the visibility of views
        nicknameText.visibility = View.VISIBLE
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE

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