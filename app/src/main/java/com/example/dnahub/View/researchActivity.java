package com.example.dnahub.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dnahub.R;

public class researchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        EditText input = findViewById(R.id.sequence);
        CheckBox gc = findViewById(R.id.checkbox1);
        CheckBox comp = findViewById(R.id.checkbox2);
        CheckBox revcomp = findViewById(R.id.checkbox3);
        CheckBox motives = findViewById(R.id.checkbox4);
        CheckBox patterns = findViewById(R.id.checkbox5);
        EditText motiveInput = findViewById(R.id.motive);
        Button button = findViewById(R.id.submit);

        motiveInput.setVisibility(View.INVISIBLE);
        motiveInput.setActivated(false);

        if(motives.isChecked()) {
            motiveInput.setVisibility(View.VISIBLE);
            motiveInput.setActivated(true);
        }
        String motive = motiveInput.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = input.getText().toString();
                Log.i("Input", "Sequence: " + inputString);
                Intent intent = new Intent(researchActivity.this, resultActivity.class);
                intent.putExtra("sequence", inputString)
                        .putExtra("gc", gc.isChecked())
                        .putExtra("comp", comp.isChecked())
                        .putExtra("rev", revcomp.isChecked())
                        .putExtra("motives", motives.isChecked())
                        .putExtra("motive", motive)
                        .putExtra("patterns", patterns.isChecked());
                startActivity(intent);
            }
        });

    }
}