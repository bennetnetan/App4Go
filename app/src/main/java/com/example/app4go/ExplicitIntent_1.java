package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ExplicitIntent_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_1);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value1 = extras.getString("Value1");
                String value2 = extras.getString("Value2");
                Toast.makeText(this, "Values:\n1. " + value1 + "\n2. " + value2, Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this, "No values passed!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "No data passed yet!", Toast.LENGTH_SHORT).show();
        }
    }
    public void cfa(View view){
        Intent cfa = new Intent(getApplicationContext(), EmplicitIntent_0.class);
        cfa.putExtra("val1", "Thank you!");
        cfa.putExtra("val2", "Gracias!");
        startActivity(cfa);
    }
    public void cfa_(View view) {
        Intent cf = new Intent(this, EmplicitIntent_0.class);
        startActivity(cf);
    }
}
