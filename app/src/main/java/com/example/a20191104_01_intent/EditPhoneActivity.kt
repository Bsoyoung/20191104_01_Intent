package com.example.a20191104_01_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_phone.*

class EditPhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone)

        phoneOkBtn.setOnClickListener {

            var intent = Intent()

            intent.putExtra("inputPhone",phoneNumEdit.text.toString())
            setResult(RESULT_OK,intent)
            finish()

        }



    }
}
