package com.example.e03list;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnListViewClicked(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void btnRecyclerView1_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView1Activity.class);
        startActivity(intent);
    }

    public void btnRecyclerView2_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView2Activity.class);
        startActivity(intent);
    }
}