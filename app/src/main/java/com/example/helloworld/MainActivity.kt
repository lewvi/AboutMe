package com.example.helloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Nutthakul")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {
        binding. apply {
            myName?.nickname = nicnameEdit.text.toString()
            invalidateAll()
            nicnameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicnameText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /*private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nicname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
 */

}

