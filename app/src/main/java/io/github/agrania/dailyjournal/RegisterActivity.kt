package io.github.agrania.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnGo: Button

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        prefUtil = PreferenceUtil.newInstance(this)

        etFullName = findViewById(R.id.et_full_name)
        etUsername = findViewById(R.id.et_username)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnGo = findViewById(R.id.btn_go)

        etFullName.setText(prefUtil.getString("FullName"))
        etUsername.setText(prefUtil.getString("Username"))
        etEmail.setText(prefUtil.getString("Email"))
        etPassword.setText(prefUtil.getString("Password"))

        btnGo.setOnClickListener {
            saveData()
            val intentWelcomeActivity = Intent(this, WelcomeActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentWelcomeActivity)
        }
    }

    private fun saveData() {
        val Username = etUsername.text.toString().trim()

        prefUtil.setString("Username", Username)

    }
}