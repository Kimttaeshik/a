package com.example.rlaxotlr

import SharedPreferenceUtils
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.content.ContentProviderCompat.requireContext
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

        val btn_save : TextView = findViewById(R.id.textView9)
        btn_save.setOnClickListener {
            SharedPreferenceUtils.saveData(this, "exname", textViews.getOrNull(0)?.text.toString())
        }

        val btn_lode : Button = findViewById(R.id.btn_lode)
        btn_lode.setOnClickListener {
            btn_lode.text = SharedPreferenceUtils.loadData(this, "exname")

        }

        val emptyConstList: List<ConstraintLayout> = listOf(
            findViewById(R.id.emptyConst1),
            findViewById(R.id.emptyConst2),
            findViewById(R.id.emptyConst3),
            findViewById(R.id.emptyConst4),
            findViewById(R.id.emptyConst5),
            // 추가적으로 필요한 emptyConst들을 여기에 추가합니다.
        )

        var currentIndex = 0


        val btn_set_plus: ImageView = findViewById(R.id.imageView66)
        btn_set_plus.setOnClickListener {
            if (0 <= currentIndex && currentIndex < emptyConstList.size) {
                val currentEmptyConst = emptyConstList[currentIndex]
                currentEmptyConst.visibility = View.VISIBLE
                currentIndex++ // 인덱스 증가
            } else {
                // 모든 emptyConst가 보여진 후에는 currentIndex를 초기화합니다.
                currentIndex = 5
                // 혹은 다른 동작을 수행할 수 있습니다.
            }
        }

        val minusButtons: List<ImageView> = listOf(
            findViewById(R.id.imageView7),
            findViewById(R.id.imageView7_01),
            findViewById(R.id.imageView7_02),
            findViewById(R.id.imageView7_03),
            findViewById(R.id.imageView7_04)
        )



//        minusButtons.forEachIndexed { index, button ->
//            button.setOnClickListener {
//                // 현재 버튼의 인덱스가 0보다 큰 경우에만 동작
//                if (currentIndex > 0) {
//                    currentIndex-- // 인덱스 감소
//                    val currentEmptyConst = emptyConstList[currentIndex]
//                    currentEmptyConst.visibility = View.GONE
//                } else {
//                    // currentIndex가 0일 때, currentIndex를 마지막 인덱스로 설정
//                    currentIndex = emptyConstList.size
//                    // 모든 emptyConst가 사라진 후에는 currentIndex를 초기화합니다.
//                    emptyConstList.forEach { it.visibility = View.GONE }
//                }
//            }
//        }



        val editTextNumbers: List<EditText> = listOf(
            findViewById(R.id.editTextNumber),
            findViewById(R.id.editTextNumber_01),
            findViewById(R.id.editTextNumber_02),
            findViewById(R.id.editTextNumber_03),
            findViewById(R.id.editTextNumber_04)
        )

        val editTextNumber2s: List<EditText> = listOf(
            findViewById(R.id.editTextNumber2),
            findViewById(R.id.editTextNumber2_01),
            findViewById(R.id.editTextNumber2_02),
            findViewById(R.id.editTextNumber2_03),
            findViewById(R.id.editTextNumber2_04)
        )

//        minusButtons.forEachIndexed { index, button ->
//            button.setOnClickListener {
//                // 현재 버튼의 인덱스가 0보다 큰 경우에만 동작
//                if (currentIndex > 0) {
//                    currentIndex-- // 인덱스 감소
//                    editTextNumbers[currentIndex].text.clear() // 현재 인덱스의 에딧 텍스트 초기화
//                    editTextNumber2s[currentIndex].text.clear() // 현재 인덱스의 에딧 텍스트 초기화
//
//                    // 다른 에딧 텍스트 뷰들을 한 칸씩 당김
//                    for (i in currentIndex until editTextNumbers.size - 1) {
//                        editTextNumbers[i].text = editTextNumbers[i + 1].text
//                        editTextNumber2s[i].text = editTextNumber2s[i + 1].text
//                    }
//                    // 마지막 에딧 텍스트 뷰 초기화
//                    editTextNumbers.last().text.clear()
//                    editTextNumber2s.last().text.clear()
//
//                    val currentEmptyConst = emptyConstList[currentIndex]
//                    currentEmptyConst.visibility = View.GONE
//                } else {
//                    // currentIndex가 0일 때, currentIndex를 마지막 인덱스로 설정
//                    currentIndex = emptyConstList.size
//                    // 모든 emptyConst가 사라진 후에는 currentIndex를 초기화합니다.
//                    emptyConstList.forEach { it.visibility = View.GONE }
//
//                    // 에딧 텍스트 초기화
//                    editTextNumbers.forEach { it.text.clear() }
//                    editTextNumber2s.forEach { it.text.clear() }
//                }
//            }
//        }

        minusButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // 현재 인덱스가 0일 때, 마지막 인덱스로 설정
                if (currentIndex == 0) {
                    currentIndex = emptyConstList.size - 1
                } else {
                    currentIndex--
                    // 현재 인덱스가 리스트 범위 내에 있는지 확인
                    if (currentIndex < editTextNumbers.size && currentIndex < editTextNumber2s.size) {
                        // 마지막 값은 초기화합니다.
                        editTextNumbers[currentIndex].text.clear()
                        editTextNumber2s[currentIndex].text.clear()
                    }


                }

                // 현재 인덱스에 해당하는 레이아웃을 숨깁니다.
                if (currentIndex < emptyConstList.size) {
                    emptyConstList[currentIndex].visibility = View.GONE
                }
            }
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
                        val emptyTextView = textViews.firstOrNull { it.text.isNullOrEmpty() && it !in usedTextViews }
                        val emptyCardView = findViewById<CardView>(R.id.cardview1)
                        val emptyCardView2 = findViewById<CardView>(R.id.cardview1_1)


                        if (emptyTextView != null ) {
                            if(emptyTextView?.text.isNullOrEmpty()) {

                                if (emptyCardView?.visibility == View.VISIBLE) emptyCardView2?.visibility =
                                    View.VISIBLE
                                if (emptyCardView?.visibility == View.GONE) emptyCardView?.visibility =
                                    View.VISIBLE
                                emptyTextView.setText("${exerciseName}")
                            }

                            else {

                            }

                        }



//                        if (emptyTextView?.text != null) {
//                            if(emptyCardView?.visibility == View.VISIBLE) emptyCardView2?.visibility = View.VISIBLE
//                            if(emptyCardView?.visibility==View.GONE) emptyCardView?.visibility = View.VISIBLE
//
//                            // Sets 또는 Weight가 비어있는 경우 처리
//                            if (sets != null && weight != null && sets.isNotEmpty() && weight.isNotEmpty()) {
//                                emptyTextView.setText("${exerciseName}")
//                                // emptyTextView.setText("${exerciseName}: ${sets.joinToString(", ")}, ${weight.joinToString(", ")}")
//                            } else {
//                                emptyTextView.setText("No data available")
//                            }
//                        }








                    }
                        // 여기서 결과 데이터를 사용하거나 처리



//                    dataList.add(Chest(it))
//                    adapter.notifyItemInserted(dataList.size - 1)
                }
            }
        }

    // ...
}
