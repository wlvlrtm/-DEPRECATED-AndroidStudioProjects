package com.example.d201914140;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String clickedRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////

        RadioCheck();
    }


    private void RadioCheck() {
        RadioGroup radioGroup;
        EditText editText;

        radioGroup = findViewById(R.id.radioGroup);
        editText = findViewById(R.id.editText);

        RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton button = findViewById(id);
                clickedRadio = button.getText().toString();
                editText.setText(clickedRadio);
            }
        };

        radioGroup.setOnCheckedChangeListener(listener1);
    }


    public void Button_OK(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(clickedRadio);
        builder.setNeutralButton(R.string.close, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}