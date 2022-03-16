package com.example.e02veiws;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    boolean isClear = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button button = findViewById(R.id.button);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_LoginId = findViewById(R.id.editText_LoginId);        // Login ID Input
                EditText editText_Password = findViewById(R.id.editText_Password);      // Password1
                EditText editText_Password2 = findViewById(R.id.editText_Password2);    // Password2
                EditText editText_email = findViewById(R.id.editText_Email);            // Email

                //--//

                String loginId = editText_LoginId.getText().toString();     // ID get
                if (isEmptyOrWhiteSpace(loginId)) { // if field is Empty; ERROR MSG
                    editText_LoginId.setError("로그인 아이디를 입력하세요.");
                    SignUpActivity.this.isClear = false;
                }

                String password = editText_Password.getText().toString();   // PSW get
                if (isEmptyOrWhiteSpace(password)) {
                    editText_Password.setError("비밀번호를 입력하세요.");
                    SignUpActivity.this.isClear = false;
                }

                String password2 = editText_Password2.getText().toString(); // PSW2 get
                if (!password2.equals(password)) {  // password != password2
                    editText_Password2.setError("비밀번호가 일치하지 않습니다.");
                    SignUpActivity.this.isClear = false;
                }

                String email = editText_email.getText().toString();

                // User Data -> Server //

                if (SignUpActivity.this.isClear) {
                    String msg = ("회원가입 성공: " + loginId + " " + email);
                    Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_LONG).show(); // Toast Msg
                }
            }
        };
        button.setOnClickListener(listener);
    }

    private boolean isEmptyOrWhiteSpace(String str) {
        if (str == null) {
            return true;
        }
        SignUpActivity.this.isClear = true;
        return str.trim().length() == 0;
    }
}