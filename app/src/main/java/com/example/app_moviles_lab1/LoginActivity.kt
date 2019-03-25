package com.example.app_moviles_lab1

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.EditText


class LoginActivity : AppCompatActivity() {
    val LOGIN_REQUEST = 1
    val MAIL = "mail: "
    val PASSWORD = "mail: "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    private fun pickContact() {
        val pickContactIntent = Intent(Intent.ACTION_PICK, Uri.parse("content://login"))
        pickContactIntent.type = Phone.CONTENT_TYPE // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, LOGIN_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Check which request we're responding to
        if (requestCode == LOGIN_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    fun loginForm(view: View){
        val intent = Intent(this, MainActivity::class.java)
        val editText = findViewById<EditText>(R.id.email)
        val email = editText.text.toString()
        intent.putExtra(MAIL, email)
        intent.putExtra(PASSWORD, email)
        startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        getIntent()

    }
}
