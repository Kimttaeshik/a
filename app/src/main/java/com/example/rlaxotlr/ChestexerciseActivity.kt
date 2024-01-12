package com.example.rlaxotlr

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

class ChestexerciseActivity : AppCompatActivity() {

    private var _binding: ChestexerciseBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Chest>
    lateinit var titleList: Array<String>
    private lateinit var adapter: AdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ChestexerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        titleList = arrayOf(

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
