package com.example.rlaxotlr

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rlaxotlr.AdapterClass
import com.example.rlaxotlr.AddActivity
import com.example.rlaxotlr.R
import com.example.rlaxotlr.sampledata.Chest
import com.example.rlaxotlr.databinding.ChestexerciseBinding
import com.example.rlaxotlr.sampledata.Custom
import com.example.rlaxotlr.sampledata.Exercise_all

@Suppress("DEPRECATION")
class ChestexerciseActivity : AppCompatActivity() {

    private var _binding: ChestexerciseBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Chest>
    lateinit var titleList: Array<String>
    private lateinit var adapter: AdapterClass
    companion object {
        const val ResultReturn = 1 // Any unique value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ChestexerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)



        titleList = arrayOf( "1. 벤치프레스", "2. 케이블 크로스오버", "3. 푸쉬업", "4. 인클라인 벤치프레스", "5. 딥스"

            // Add your array elements here
        )

        recyclerView = binding.rvExercise
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf()
        getData()

        adapter = AdapterClass(dataList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterClass.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d("position", position.toString())
                Log.d("adapter", (adapter.itemCount - 1).toString())


                var Sets: ArrayList<Int> = arrayListOf(0,0,0,0,0)
                var Weight: ArrayList<Int> = arrayListOf(0,0,0,0,0)


                when (position){
                    0 -> {
                        val reintent = Intent(this@ChestexerciseActivity, CustomsettingActivity::class.java)
                        reintent.putExtra("커스텀", Exercise_all(exercise_name = titleList.get(0), Sets = Sets, Weight = Weight))
                        setResult(ResultReturn, reintent)
                        finish()

                    }

                    1 -> {
                        val reintent = Intent(this@ChestexerciseActivity, CustomsettingActivity::class.java)
                        reintent.putExtra("커스텀", Exercise_all(exercise_name = titleList.get(1), Sets = Sets, Weight = Weight))
                        setResult(ResultReturn, reintent)
                        finish()
                    }

                    2 -> {
                        val reintent = Intent(this@ChestexerciseActivity, CustomsettingActivity::class.java)
                        reintent.putExtra("커스텀", Exercise_all(exercise_name = titleList.get(2), Sets = Sets, Weight = Weight))
                        setResult(ResultReturn, reintent)
                        finish()
                    }
                    3 -> {
                        val reintent = Intent(this@ChestexerciseActivity, CustomsettingActivity::class.java)
                        reintent.putExtra("커스텀", Exercise_all(exercise_name = titleList.get(3), Sets = Sets, Weight = Weight))
                        setResult(ResultReturn, reintent)
                        finish()
                    }
                    4 -> {
                        val reintent = Intent(this@ChestexerciseActivity, CustomsettingActivity::class.java)
                        reintent.putExtra("커스텀", Exercise_all(exercise_name = "", Sets = Sets, Weight = Weight))
                        setResult(ResultReturn, reintent)
                        finish()
                    }

                }

                if (position == adapter.itemCount - 1) {
                    val intent = Intent(this@ChestexerciseActivity, AddActivity::class.java)
                    requestLauncher.launch(intent)

                }




            }


        })


    }

    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AddActivity.RESULT_ADD_TASK) {
                val newTask = result.data?.getStringExtra("newTask")
                newTask?.let {
                    dataList.add(Chest(it))
                    adapter.notifyItemInserted(dataList.size - 1)
                }
            }
        }







    private fun getData() {
        for (i in titleList.indices) {
            val dataClass = Chest(titleList[i])
            dataList.add(dataClass)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
