package com.example.rlaxotlr

import SharedPreferenceUtils
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
import com.example.rlaxotlr.sampledata.ExerciseSave
import com.example.rlaxotlr.sampledata.Exercise_all

@Suppress("DEPRECATION")
class CustomsettingActivity : AppCompatActivity() {
    public val textViews: Array<EditText> by lazy {
        arrayOf(
            findViewById(R.id.textView),
            findViewById(R.id.textView_1),
            findViewById(R.id.textView_2),
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

        val btn_save: TextView = findViewById(R.id.textView9)
        btn_save.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }



//        val btn_save: TextView = findViewById(R.id.textView9)
//        btn_save.setOnClickListener {
//            val exName: String = textViews.getOrNull(0)?.text.toString()
//            SharedPreferenceUtils.saveData(this, "exname", ExerciseSave(exName))
//        }
//
//        val btn_load: Button = findViewById(R.id.btn_lode)
//        btn_load.setOnClickListener {
//            val exName: String = SharedPreferenceUtils.loadData(this, "exname")?.name ?: ""
//            btn_load.text = exName
//        }


        ///////////////////////////////////여기서부터///////////////

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



        minusButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // 현재 버튼의 인덱스가 0보다 큰 경우에만 동작
                if (currentIndex > 0) {
                    currentIndex-- // 인덱스 감소

                    if (index == 0) {
                        for (i in 0 until 4) {
                            editTextNumbers[i].text = editTextNumbers[i + 1].text
                            editTextNumber2s[i].text = editTextNumber2s[i + 1].text
                        }
                    }

                    if (index == 1){
                        for(i in 1 until  4){
                            editTextNumbers[i].text = editTextNumbers[i + 1].text
                            editTextNumber2s[i].text = editTextNumber2s[i + 1].text
                        }
                    }

                    if (index == 2){
                        for(i in 2 until  4){
                            editTextNumbers[i].text = editTextNumbers[i + 1].text
                            editTextNumber2s[i].text = editTextNumber2s[i + 1].text
                        }
                    }

                    if (index == 3){
                        for(i in 3 until  4){
                            editTextNumbers[i].text = editTextNumbers[i + 1].text
                            editTextNumber2s[i].text = editTextNumber2s[i + 1].text
                        }
                    }

                    editTextNumbers[currentIndex].text.clear() // 현재 인덱스의 에딧 텍스트 초기화
                    editTextNumber2s[currentIndex].text.clear() // 현재 인덱스의 에딧 텍스트 초기화



                    val currentEmptyConst = emptyConstList[currentIndex]
                    currentEmptyConst.visibility = View.GONE
                } else {
                    // currentIndex가 0일 때, currentIndex를 마지막 인덱스로 설정
                    currentIndex = emptyConstList.size
                    // 모든 emptyConst가 사라진 후에는 currentIndex를 초기화합니다.
                    emptyConstList.forEach { it.visibility = View.GONE }

                    // 에딧 텍스트 초기화
                    editTextNumbers.forEach { it.text.clear() }
                    editTextNumber2s.forEach { it.text.clear() }
                }
            }
        }

        ////////////////////여기까지////////////////////

        val emptyConstList_1: List<ConstraintLayout> = listOf(
            findViewById(R.id.emptyConst1_1),
            findViewById(R.id.emptyConst2_1),
            findViewById(R.id.emptyConst3_1),
            findViewById(R.id.emptyConst4_1),
            findViewById(R.id.emptyConst5_1),
            // 추가적으로 필요한 emptyConst들을 여기에 추가합니다.
        )

        var currentIndex_1 = 0


        val btn_set_plus_1: ImageView = findViewById(R.id.imageView66_1)
        btn_set_plus_1.setOnClickListener {
            if (0 <= currentIndex_1 && currentIndex_1 < emptyConstList_1.size) {
                val currentEmptyConst_1 = emptyConstList_1[currentIndex_1]
                currentEmptyConst_1.visibility = View.VISIBLE
                currentIndex_1++ // 인덱스 증가
            } else {
                // 모든 emptyConst가 보여진 후에는 currentIndex를 초기화합니다.
                currentIndex_1 = 5
                // 혹은 다른 동작을 수행할 수 있습니다.
            }
        }

        val minusButtons_1: List<ImageView> = listOf(
            findViewById(R.id.imageView7_1),
            findViewById(R.id.imageView7_01_1),
            findViewById(R.id.imageView7_02_1),
            findViewById(R.id.imageView7_03_1),
            findViewById(R.id.imageView7_04_1)
        )



        val editTextNumbers_1: List<EditText> = listOf(
            findViewById(R.id.editTextNumber_1),
            findViewById(R.id.editTextNumber_01_1),
            findViewById(R.id.editTextNumber_02_1),
            findViewById(R.id.editTextNumber_03_1),
            findViewById(R.id.editTextNumber_04_1)
        )

        val editTextNumber2s_1: List<EditText> = listOf(
            findViewById(R.id.editTextNumber2_1),
            findViewById(R.id.editTextNumber2_01_1),
            findViewById(R.id.editTextNumber2_02_1),
            findViewById(R.id.editTextNumber2_03_1),
            findViewById(R.id.editTextNumber2_04_1)
        )



        minusButtons_1.forEachIndexed { index, button ->
            button.setOnClickListener {
                // 현재 버튼의 인덱스가 0보다 큰 경우에만 동작
                if (currentIndex_1 > 0) {
                    currentIndex_1-- // 인덱스 감소

                    if (index == 0) {
                        for (i in 0 until 4) {
                            editTextNumbers_1[i].text = editTextNumbers_1[i + 1].text
                            editTextNumber2s_1[i].text = editTextNumber2s_1[i + 1].text
                        }
                    }

                    if (index == 1){
                        for(i in 1 until  4){
                            editTextNumbers_1[i].text = editTextNumbers_1[i + 1].text
                            editTextNumber2s_1[i].text = editTextNumber2s_1[i + 1].text
                        }
                    }

                    if (index == 2){
                        for(i in 2 until  4){
                            editTextNumbers_1[i].text = editTextNumbers_1[i + 1].text
                            editTextNumber2s_1[i].text = editTextNumber2s_1[i + 1].text
                        }
                    }

                    if (index == 3){
                        for(i in 3 until  4){
                            editTextNumbers_1[i].text = editTextNumbers_1[i + 1].text
                            editTextNumber2s_1[i].text = editTextNumber2s_1[i + 1].text
                        }
                    }

                    editTextNumbers_1[currentIndex_1].text.clear() // 현재 인덱스의 에딧 텍스트 초기화
                    editTextNumber2s_1[currentIndex_1].text.clear() // 현재 인덱스의 에딧 텍스트 초기화



                    val currentEmptyConst_1 = emptyConstList_1[currentIndex_1]
                    currentEmptyConst_1.visibility = View.GONE
                } else {
                    // currentIndex가 0일 때, currentIndex를 마지막 인덱스로 설정
                    currentIndex_1 = emptyConstList_1.size
                    // 모든 emptyConst가 사라진 후에는 currentIndex를 초기화합니다.
                    emptyConstList_1.forEach { it.visibility = View.GONE }

                    // 에딧 텍스트 초기화
                    editTextNumbers_1.forEach { it.text.clear() }
                    editTextNumber2s_1.forEach { it.text.clear() }
                }
            }
        }
        //////////////////////////////////////////////2222222222222222222////////////////////
        val emptyConstList_2: List<ConstraintLayout> = listOf(
            findViewById(R.id.emptyConst1_2),
            findViewById(R.id.emptyConst2_2),
            findViewById(R.id.emptyConst3_2),
            findViewById(R.id.emptyConst4_2),
            findViewById(R.id.emptyConst5_2),
            // 추가적으로 필요한 emptyConst들을 여기에 추가합니다.
        )

        var currentIndex_2 = 0

        val btn_set_plus_2: ImageView = findViewById(R.id.imageView66_2)
        btn_set_plus_2.setOnClickListener {
            if (0 <= currentIndex_2 && currentIndex_2 < emptyConstList_2.size) {
                val currentEmptyConst_2 = emptyConstList_2[currentIndex_2]
                currentEmptyConst_2.visibility = View.VISIBLE
                currentIndex_2++ // 인덱스 증가
            } else {
                // 모든 emptyConst가 보여진 후에는 currentIndex를 초기화합니다.
                currentIndex_2 = 5
                // 혹은 다른 동작을 수행할 수 있습니다.
            }
        }

        val minusButtons_2: List<ImageView> = listOf(
            findViewById(R.id.imageView7_2),
            findViewById(R.id.imageView7_01_2),
            findViewById(R.id.imageView7_02_2),
            findViewById(R.id.imageView7_03_2),
            findViewById(R.id.imageView7_04_2)
        )

        val editTextNumbers_2: List<EditText> = listOf(
            findViewById(R.id.editTextNumber_2),
            findViewById(R.id.editTextNumber_01_2),
            findViewById(R.id.editTextNumber_02_2),
            findViewById(R.id.editTextNumber_03_2),
            findViewById(R.id.editTextNumber_04_2)
        )

        val editTextNumber2s_2: List<EditText> = listOf(
            findViewById(R.id.editTextNumber2_2),
            findViewById(R.id.editTextNumber2_01_2),
            findViewById(R.id.editTextNumber2_02_2),
            findViewById(R.id.editTextNumber2_03_2),
            findViewById(R.id.editTextNumber2_04_2)
        )

        minusButtons_2.forEachIndexed { index, button ->
            button.setOnClickListener {
                // 현재 버튼의 인덱스가 0보다 큰 경우에만 동작
                if (currentIndex_2 > 0) {
                    currentIndex_2-- // 인덱스 감소

                    if (index == 0) {
                        for (i in 0 until 4) {
                            editTextNumbers_2[i].text = editTextNumbers_2[i + 1].text
                            editTextNumber2s_2[i].text = editTextNumber2s_2[i + 1].text
                        }
                    }

                    if (index == 1) {
                        for (i in 1 until 4) {
                            editTextNumbers_2[i].text = editTextNumbers_2[i + 1].text
                            editTextNumber2s_2[i].text = editTextNumber2s_2[i + 1].text
                        }
                    }

                    if (index == 2) {
                        for (i in 2 until 4) {
                            editTextNumbers_2[i].text = editTextNumbers_2[i + 1].text
                            editTextNumber2s_2[i].text = editTextNumber2s_2[i + 1].text
                        }
                    }

                    if (index == 3) {
                        for (i in 3 until 4) {
                            editTextNumbers_2[i].text = editTextNumbers_2[i + 1].text
                            editTextNumber2s_2[i].text = editTextNumber2s_2[i + 1].text
                        }
                    }

                    editTextNumbers_2[currentIndex_2].text.clear() // 현재 인덱스의 에딧 텍스트 초기화
                    editTextNumber2s_2[currentIndex_2].text.clear() // 현재 인덱스의 에딧 텍스트 초기화

                    val currentEmptyConst_2 = emptyConstList_2[currentIndex_2]
                    currentEmptyConst_2.visibility = View.GONE
                } else {
                    // currentIndex가 0일 때, currentIndex를 마지막 인덱스로 설정
                    currentIndex_2 = emptyConstList_2.size
                    // 모든 emptyConst가 사라진 후에는 currentIndex를 초기화합니다.
                    emptyConstList_2.forEach { it.visibility = View.GONE }

                    // 에딧 텍스트 초기화
                    editTextNumbers_2.forEach { it.text.clear() }
                    editTextNumber2s_2.forEach { it.text.clear() }
                }
            }
        }
        /////////////////////////////33333333333333/////////////


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
                        val emptyCardView3 = findViewById<CardView>(R.id.cardview1_2)


                        if (emptyTextView != null ) {
                            if(emptyTextView?.text.isNullOrEmpty()) {

                                if (emptyCardView2?.visibility == View.VISIBLE) emptyCardView3?.visibility =
                                    View.VISIBLE
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
