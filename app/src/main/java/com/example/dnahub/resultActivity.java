package com.example.dnahub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String seq = intent.getStringExtra("sequence");
        TextView text = findViewById(R.id.result);
        text.setText("The Sequence " + seq + " with the length " + seq.length() + "..." );

    }
}