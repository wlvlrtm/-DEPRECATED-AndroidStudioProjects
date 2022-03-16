package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Super 클래스 호출
        setContentView(R.layout.activity_main); // activity_main 레이아웃을 현재 뷰로 설정

        Button b = (Button)findViewById(R.id.button);   // ID로 버튼 오브젝트 탐색 & 할당
        View.OnClickListener listenerObj = new View.OnClickListener() { // 리스너 생성; 버튼 클릭 감지 시,
            // 버튼 클릭 시 일어나는 일 정의 //
            @Override
            public void onClick(View v) { // EditText
                EditText e = (EditText)findViewById(R.id.editText); // ID로 EditText 필드 탐색
                CharSequence s = e.getText();   // EditText에 입력된 텍스트 get
                TextView t = (TextView)findViewById(R.id.textView); // TextView 생성
                t.setText(s);   // TextView 텍스트를 get한 텍스트로 설정
            }
            // END //
        };
        b.setOnClickListener(listenerObj);  // 클릭 감지 시 listerObj를 호출하도록 리스너 등록
    }
}
