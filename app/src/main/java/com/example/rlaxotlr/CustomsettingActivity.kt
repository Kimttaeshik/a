package com.example.rlaxotlr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rlaxotlr.sampledata.Custom

class CustomsettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customsetting)


        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, KindActivity::class.java)
            startActivity(intent)


        }

        var intent:Intent=getIntent()
        var kame = intent.getParcelableExtra("커스텀", Custom::class.java)
//        if (intent.hasExtra("세트")) {
//            var kname = intent.getParcelableExtra("세트")
//            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
//               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */
//
//        }

        val textView : TextView = findViewById(R.id.textView)
        val textView1 : TextView = findViewById(R.id.textView1)
        val textView2 : TextView = findViewById(R.id.textView2)
        val textView3 : TextView = findViewById(R.id.textView3)
        val textView4 : TextView = findViewById(R.id.textView4)
        val textView5 : TextView = findViewById(R.id.textView5)

        if (kame != null) {
            textView.text=kame.custom_ex.get(0).Sets.get(0).weight.toString()
        }
        if (kame != null) {
            textView2.text=kame.custom_ex.get(0).Sets.get(0).num.toString()
        }
        if (kame != null) {
            textView3.text=kame.custom_ex.get(0).Sets.get(0).set_num.toString()
        }
        if (kame != null) {
            textView4.text=kame.custom_ex.get(0).exercise_name.toString()
        }
        if (kame != null) {
            textView5.text=kame.custom_ex.get(0).exercise_name.toString()
        }


        if (kame != null) {
            textView1.text=kame.custom_name.toString()
        }



    }
}