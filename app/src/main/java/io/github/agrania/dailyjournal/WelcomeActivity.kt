package io.github.agrania.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class WelcomeActivity : AppCompatActivity() {

    private lateinit var btnFinish: Button
    private lateinit var etDate: EditText
    private lateinit var etTittle: EditText
    private lateinit var etContent: EditText
    private lateinit var tvWelcome: TextView
    private lateinit var tvUsername: TextView

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val dataFragment = DataFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentdata, dataFragment)
            commit()
        }

        btnFinish.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentdata, dataFragment)
                addToBackStack(null)
                commit()
           }
        }

        prefUtil = PreferenceUtil.newInstance(this)

        etDate = findViewById(R.id.et_date)
        etTittle = findViewById(R.id.et_tittle)
        etContent = findViewById(R.id.et_content)
        btnFinish = findViewById(R.id.btn_finish)
        tvWelcome = findViewById(R.id.tv_welcome)
        tvUsername = findViewById(R.id.tv_username)

        updateData()

    }

    private fun updateData(){
        val Username = prefUtil.getString("Username")
        val welcomeName = "$Username"
        tvUsername.text = welcomeName
        if (Username.isNullOrEmpty()){
            tvUsername.visibility = View.GONE
        } else {
            tvUsername.visibility = View.VISIBLE
        }
    }
}