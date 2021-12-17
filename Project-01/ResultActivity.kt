package fastcampus.aop.part2.chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0) // intent로 얻은 신장값을 받는 방법 + 신장값이 없을 경우 값(디폴트값)은 0
        val weight = intent.getIntExtra("weight", 0) // intent로 얻은 신장값을 받는 방법 + 신장값이 없을 경우 값(디폴트값)은 0

        Log.d("ResultActivity", "height : $height , weight : $weight") //값이 잘 들어왓는지 확인하는 디버그 방법

        val bmi = weight / (height / 100.0).pow(2.0) // bmi 공식에 맞게 결과값 출력
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText

    }
}
