package com.example.e02veiws;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MemoActivity extends AppCompatActivity {

    private boolean isClear = true;
    private static boolean isDeOneShot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        /////

        Button saveButton = findViewById(R.id.button_Save);             // button_Save
        EditText text_Title = findViewById(R.id.editText_Title);        // editText_Title
        EditText text_Content = findViewById(R.id.editText_Content);    // editText_Content

        if (!isDeOneShot) { // Set a Default Message (ONE SHOT); Title & Content
            String defaultTitle = "공지사항입니다.";
            String defaultContent = "4주차나 5주차에 구현 시험을 봅니다.";

            text_Title.setText(defaultTitle);
            text_Content.setText(defaultContent);
            isDeOneShot = true;
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = text_Title.getText().toString();
                if (isEmptyOrWhiteSpace(title)) {   // IF, editText_Title is EMPTY
                    text_Title.setError("제목을 입력하세요.");
                    MemoActivity.this.isClear = false;
                }

                String content = text_Content.getText().toString();
                if (isEmptyOrWhiteSpace(content)) { // IF, editText_Content is EMPTY
                    text_Content.setError("내용을 입력하세요.");
                    MemoActivity.this.isClear = false;
                }

                // Memo Save Data -> Server //

                if (MemoActivity.this.isClear) {    // ALL CLEAR, READY 2 SAVE! :D
                    String msg = "저장 성공: " + title;
                    Toast.makeText(MemoActivity.this, msg, Toast.LENGTH_LONG).show();
                }
            }
        };
        saveButton.setOnClickListener(listener);
    }


    private boolean isEmptyOrWhiteSpace(String str) {
        if (str == null) {
            return true;
        }

        MemoActivity.this.isClear = true;

        return str.trim().length() == 0;
    }
}