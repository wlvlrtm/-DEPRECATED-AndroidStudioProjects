package com.example.e03list;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /////

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayList);

        arrayList.add("One");
        arrayList.add("Two");

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button b = findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText editText = findViewById(R.id.editText);
                CharSequence str = editText.getText();
                editText.setText("");

                arrayList.add(str.toString());
                adapter.notifyDataSetChanged(); // Data Update
            }
        });
    }
}
