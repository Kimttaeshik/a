package com.example.rlaxotlr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.rlaxotlr.sampledata.Custom
import com.example.rlaxotlr.sampledata.Exercise_kind

class IncustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incustom)


        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, SetActivity::class.java)
            startActivity(intent)


        }

        var intent:Intent=getIntent()
        var kame = intent.getParcelableExtra("운동", Exercise_kind::class.java)
//        if (intent.hasExtra("세트")) {
//            var kname = intent.getParcelableExtra("세트")
//            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
//               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */
//
//        }

        val textView : TextView = findViewById(R.id.textView)
        val textView1 : TextView = findViewById(R.id.textView1)

        if (kame != null) {
            textView.text=kame.Sets.get(0).num.toString()
        }
        if (kame != null) {
            textView1.text=kame.exercise_name.toString()
        }

        var ame  = ArrayList<Exercise_kind>()
        if (kame != null) {
            ame.add(kame)
        }
        val custoname : String = "커스텀1"
        val btn_c: Button = findViewById(R.id.btn_c)
        btn_c.setOnClickListener {
            val nextintent = Intent(this, CustomsettingActivity::class.java)
            nextintent.putExtra("커스텀", Custom(custom_ex = ame, custom_name = custoname))
//            nextintent.putExtra("number", 12345)


            startActivity(nextintent)
//            setResult(99, nextintent)
//
//            finish()
        }

    }
}