package fastcampus.aop.part2.chapter01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 사용자에게 보여줄 화면을 받는 방법

        val heightEditText: EditText = findViewById(R.id.heightEditText) // 신장값을 입력받기 위한, 밸류 객체 생성 + xml의 EditText와 연결(기존 방법)
        val weightEditText = findViewById<EditText>(R.id.weightEditText) // 체중값을 입력받기 위한, 밸류 객체 생성 + xml의 EditText와 연결(제네릭 방법)

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener { // 버튼클릭을 수행시키는 메서드(: setOnClickListener )
            Log.d("MainActivity", "ResultButton 이 클릭되었습니다.") // 디버그 방법

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) { // 신장값과 체중값의 입력값이 '비엇을 때'를 처리하기 위함
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show() // 빈 값일 때, 비었다고 알려주는 메세지 생성(짧게)
                return@setOnClickListener // 함수의 결과 값을 리턴할 때, 어떤 함수를 리턴할지 선택하기 위해 @기호+함수이름을 사용.
            }

            // 이 아래로는 절대 빈 값이 올 수 없음.

            val height: Int = heightEditText.text.toString().toInt() // 입력된 신장값을 '스트링'으로 변환 후 '정수형'으로 다시 변환
            val weight: Int = weightEditText.text.toString().toInt() // 입력된 신장값을 '스트링'으로 변환 후 '정수형'으로 다시 변환

            val intent = Intent(this, ResultActivity::class.java) // 결과화면과 화면을 이어주기 위한 방법 : intent
           
            intent.putExtra("height", height) // 입력된 신장값을 결과화면에 넘겨주는 방벙
            intent.putExtra("weight",weight)  // 입력된 신장값을 결과화면에 넘겨주는 방벙

             startActivity(intent)        // intent 실행 방법 (중요! : <activity android:name=".ResultActivity"/> 을 AndroidManifest에 추가해야 가능)

        }

    }
}
