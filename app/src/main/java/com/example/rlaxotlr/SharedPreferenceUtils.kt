// SharedPreferenceUtils.kt

import android.content.Context
import android.content.SharedPreferences
import com.example.rlaxotlr.sampledata.ExerciseSave

object SharedPreferenceUtils {


    fun saveData(context: Context, key: String, exercises: List<List<ExerciseSave>>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        for ((index, exerciseList) in exercises.withIndex()) {
            for ((subIndex, exercise) in exerciseList.withIndex()) {
                editor.putString("${key}_${index}_weight_$subIndex", exercise.weight.toString())
                editor.putString("${key}_${index}_reps_$subIndex", exercise.reps.toString())
            }
        }
        editor.apply()
    }


    fun loadData(context: Context, key: String, defaultValue: List<List<ExerciseSave>> = emptyList()): List<List<ExerciseSave>> {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val exercises: MutableList<MutableList<ExerciseSave>> = mutableListOf()
        var index = 0
        while (true) {
            val weightString = sharedPreferences.getString("${key}_${index}_weight_0", null)
            val repsString = sharedPreferences.getString("${key}_${index}_reps_0", null)
            if (weightString == null || repsString == null) {
                break
            }
            if (exercises.size <= index) {
                exercises.add(mutableListOf())
            }
            exercises[index].add(ExerciseSave(weightString.toInt(), repsString.toInt()))
            index++
        }
        return if (exercises.isEmpty()) defaultValue else exercises
    }



}
