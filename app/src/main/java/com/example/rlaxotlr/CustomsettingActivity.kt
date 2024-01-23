package com.example.rlaxotlr

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.rlaxotlr.sampledata.Chest
import com.example.rlaxotlr.sampledata.Custom
import com.example.rlaxotlr.sampledata.Exercise_all

@Suppress("DEPRECATION")
class CustomsettingActivity : AppCompatActivity() {
    public val textViews: Array<EditText> by lazy {
        arrayOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView_1),
//            findViewById(R.id.textView2),
//            findViewById(R.id.textView3),
//            findViewById(R.id.textView4),
//            findViewById(R.id.textView5)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customsetting)

        val btn: ImageView = findViewById(R.id.imageView9)
        btn.setOnClickListener {
            val intent = Intent(this, ChestexerciseActivity::class.java)
            requestLauncher.launch(intent)
        }

        // onResume에서 데이터 갱신 처리
    }





//    override fun onResume() {
//        super.onResume()
//
//        // onActivityResult를 대신하여 직접 결과를 받아옴
//        val test = intent?.getParcelableExtra<Exercise_all>("커스텀")
//
//
//
////            val intent: Intent = getIntent()
////            val test = intent.getParcelableExtra("커스텀", Exercise_all::class.java)
//
//    }

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == ChestexerciseActivity.ResultReturn) {
                val test = result.data?.getParcelableExtra<Exercise_all>("커스텀")
                test?.let {
                    if (test != null) {
                        val exerciseName = test.exercise_name
                        val sets = test.Sets
                        val weight = test.Weight

                        // 이미 값이 채워진 TextView 중에서 이전에 사용된 TextView를 제외하고 찾기
                        val usedTextViews = textViews.filterNot { it.text.isNullOrEmpty() }
                        val emptyTextView =
                            textViews.firstOrNull { it.text.isNullOrEmpty() && it !in usedTextViews }

                        if (emptyTextView != null) {
                            // Sets 또는 Weight가 비어있는 경우 처리
                            if (sets != null && weight != null && sets.isNotEmpty() && weight.isNotEmpty()) {
                                emptyTextView.setText("${exerciseName}")
//                                emptyTextView.setText("${exerciseName}: ${sets.joinToString(", ")}, ${
//                                    weight.joinToString(", ")
//                                }")
                            } else {
                                emptyTextView.setText("No data available")
                            }
                        }
                        // 여기서 결과 데이터를 사용하거나 처리
                    }
//                    dataList.add(Chest(it))
//                    adapter.notifyItemInserted(dataList.size - 1)
                }
            }
        }

    // ...
}
