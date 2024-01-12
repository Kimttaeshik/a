package com.example.rlaxotlr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rlaxotlr.sampledata.Exercise_kind
import com.example.rlaxotlr.sampledata.Set

class ExercisekindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercisekind)



        var intent:Intent=getIntent()
        var ame  = ArrayList<Set>()
//        kame.add(Set(0,0,0))
        var kname= intent.getParcelableExtra("세트", Set::class.java)
        if (kname != null) {
        ame.add(kname)
        }


//        if (intent.hasExtra("세트")) {
//            var kname = intent.getParcelableExtra("세트")
//            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
//               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */
//
        



        var exercise_name = arrayListOf<String>("벤치프레스","렛풀다운","스쿼트")
        val btn_b: Button = findViewById(R.id.btn_b)
        val btn_b2: Button = findViewById(R.id.btn_b2)
        val btn_b3: Button = findViewById(R.id.btn_b3)

        val btn_b4: Button = findViewById(R.id.btn_b1)
        btn_b4.setOnClickListener {
            val nextintent = Intent(this, ChestexerciseActivity::class.java)
            startActivity(nextintent)
//            setResult(99, nextintent)
//
            finish()
        }

        btn_b.setOnClickListener {
            val nextintent = Intent(this, IncustomActivity::class.java)
            nextintent.putExtra("운동", Exercise_kind(Sets = ame, exercise_name = exercise_name[0]))
//            nextintent.putExtra("number", 12345)


            startActivity(nextintent)
//            setResult(99, nextintent)
//
//            finish()
        }

        btn_b2.setOnClickListener {
            val nextintent = Intent(this, IncustomActivity::class.java)
            nextintent.putExtra("운동", Exercise_kind(Sets = ame, exercise_name = exercise_name[1]))
//            nextintent.putExtra("number", 12345)


            startActivity(nextintent)
//            setResult(99, nextintent)
//
//            finish()
        }

        btn_b3.setOnClickListener {
            val nextintent = Intent(this, IncustomActivity::class.java)
            nextintent.putExtra("운동", Exercise_kind(Sets = ame, exercise_name = exercise_name[2]))
//            nextintent.putExtra("number", 12345)


            startActivity(nextintent)
//            setResult(99, nextintent)
//
//            finish()
        }


    }




}