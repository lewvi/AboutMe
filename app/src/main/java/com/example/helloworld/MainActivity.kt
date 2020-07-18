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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.nicname_text).setOnClickListener {
            updateNickname(it)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicnameText.text = binding.nicnameEdit.text
        binding.nicnameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicnameText.visibility = View.VISIBLE

        binding.nicnameText.text = binding.nicnameEdit.text.toString()

        binding.apply {
            nicnameText.text = nicnameEdit.text.toString()
            nicnameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicnameText.visibility = View.VISIBLE
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nicname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nicname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
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

    private fun clickHandlerFunction(viewThatIsClicked: View) {

    }

}

