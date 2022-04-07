package com.example.e02veiws;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class CheckboxesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes);

        /////---/////

        final CheckBox checkBox1 = findViewById(R.id.checkBox1);
        final Switch switch1 = findViewById(R.id.switch1);
        final RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        final RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);

        Button btnSave = findViewById(R.id.btnSave);


        // checkBox1 //
        CompoundButton.OnCheckedChangeListener listener1 =
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String str = String.format("%s : %b", compoundButton.getText().toString(), b);
                Toast.makeText(CheckboxesActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        };

        // Listener SET //
        checkBox1.setOnCheckedChangeListener(listener1);
        switch1.setOnCheckedChangeListener(listener1);

        // radioGroup1 //
        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                String str = radioButton.getText().toString();
                Toast.makeText(CheckboxesActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        };

        // Listener SET //
        radioGroup1.setOnCheckedChangeListener(listener2);

        // radioGroup2 //
        RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int imageID = 0;    // imageView
                ImageView imageView = findViewById(R.id.imageView);

                switch (i) {
                    case R.id.radioCat:
                        imageID = R.drawable.animal_cat_large;
                        break;
                    case R.id.radioDog:
                        imageID = R.drawable.animal_dog_large;
                        break;
                    case R.id.radioOwl:
                        imageID = R.drawable.animal_owl_large;
                        break;
                }

                imageView.setImageResource(imageID);    // Image Changes using imageID
            }
        };

        // Listener SET //
        radioGroup2.setOnCheckedChangeListener(listener3);

        // btnSave //
        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = ("checkBox1 = " + checkBox1.isChecked() + " ");
                str += ("switch1 = " + switch1.isChecked() + " ");
                str += ("radioGroup1 = ");
                switch (radioGroup1.getCheckedRadioButtonId()) {
                    case R.id.redButton:
                        str += "red";
                        break;
                    case R.id.yellowButton:
                        str += "yellow";
                        break;
                    case R.id.blueButton:
                        str += "blue";
                        break;
                }
                str += (" radioGroup2 = ");
                switch (radioGroup2.getCheckedRadioButtonId()) {
                    case R.id.radioCat:
                        str += "Cat";
                        break;
                    case R.id.radioDog:
                        str += "Dog";
                        break;
                    case R.id.radioOwl:
                        str += "Owl";
                        break;
                }

                Toast.makeText(CheckboxesActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        };

        // Listener SET //
        btnSave.setOnClickListener(listener4);
    }
}