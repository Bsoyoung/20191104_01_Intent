package com.example.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var REQ_CODE_FOR_NAME = 1000
    var REQ_CODE_FOR_PHONE = 9999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInputBtn.setOnClickListener {

            var intent = Intent(this,EditUserInfoActivity::class.java)

            if(nameTxt.text.toString() != "이름 입력 필요"){
                intent.putExtra("userName",nameEdt.text.toString())
            }

            startActivityForResult(intent,REQ_CODE_FOR_NAME)
        }

        phoneNumInputBtn.setOnClickListener {

            var intent = Intent(this,EditPhoneActivity::class.java)
            startActivityForResult(intent,REQ_CODE_FOR_PHONE)

        }

        phoneNumDialBtn.setOnClickListener {

            var uri = Uri.parse("tel:01072255710") //띄어쓰기 하면 안됨.

            var intent = Intent(Intent.ACTION_DIAL,uri)

            startActivity(intent)

        }

        phoneNumCallBtn.setOnClickListener {
            /*
            var uri = Uri.parse("tel:01072255710")
            var intent = Intent(Intent.ACTION_CALL,uri)
            startActivity(intent)*/
        }

        smsBtn.setOnClickListener {
            var uri = Uri.parse("smsto:01072255710")
            var intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body","우리가 만든 앱입니다.")
            startActivity(intent)
        }

        webLinkBtn.setOnClickListener {
            var uri = Uri.parse("http://naver.com")
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_CODE_FOR_NAME){
            if(resultCode == RESULT_OK){

                var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()

                inputNameData?.let {

                    nameTxt.text = inputNameData

                    var myName:String? = null
                }

            }
        }
        else if(requestCode == REQ_CODE_FOR_PHONE){
            if(resultCode == RESULT_OK){

                var inputPhoneData = data?.getStringExtra("inputPhone")?.toLowerCase()

                inputPhoneData?.let{

                    phoneNumTxt.text = inputPhoneData


                }
            }
        }




    }
}
