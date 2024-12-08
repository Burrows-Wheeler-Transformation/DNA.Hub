package com.example.dnahub.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dnahub.Controller.SequenceValidator;
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

        motives.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Log.i("View", "motive Input activated");
                motiveInput.setVisibility(View.VISIBLE);
                motiveInput.setActivated(true);
            } else {
                Log.i("View", "motive Input deactivated");
                motiveInput.setVisibility(View.INVISIBLE);
                motiveInput.setActivated(false);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motive = motiveInput.getText().toString().toUpperCase();
                String inputString = input.getText().toString().toUpperCase();
                SequenceValidator val = new SequenceValidator();
                Log.i("motive Status" , String.valueOf(motives.isChecked()));
                Log.i("motive String", motive);
                if(inputString.isEmpty()){
                    Log.i("submission", "Empty sequence");
                    Toast.makeText(researchActivity.this, "The Sequence shouldnt be null", Toast.LENGTH_LONG).show();
                    return;
                }
                if(motives.isChecked() && motive.isEmpty()) {
                    Log.i("submission", "Empty motive");
                    Toast.makeText(researchActivity.this,
                            "You need to give a motive to search in the sequence!", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!val.validate(inputString)) {
                    Log.i("submission", "invalid Sequence");
                    Toast.makeText(researchActivity.this, "Invalid Characters in Sequence given", Toast.LENGTH_LONG).show();
                    return;
                }
                if(motives.isChecked() && !val.validate(motive)) {
                    Log.i("submission", "Invalid motive!");
                    Toast.makeText(researchActivity.this, "Invalid Characters in motive given", Toast.LENGTH_LONG).show();
                    return;
                }
                if(motive.length() > inputString.length()) {
                    Toast.makeText(researchActivity.this, "The motive shouldn't be longer than the Sequnce", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(researchActivity.this, resultActivity.class);
                intent.putExtra("sequence", inputString)
                        .putExtra("gc", gc.isChecked())
                        .putExtra("comp", comp.isChecked())
                        .putExtra("rev", revcomp.isChecked())
                        .putExtra("motives", motives.isChecked())
                        .putExtra("motive", motive)
                        .putExtra("patterns", patterns.isChecked());
                startActivity(intent);
                Log.i("gc", String.valueOf(gc.isChecked()));
                Log.i("comp", String.valueOf(comp.isChecked()));
                Log.i("rev", String.valueOf(revcomp.isChecked()));
                Log.i("patterns", String.valueOf(patterns.isChecked()));
            }
        });
    }
}