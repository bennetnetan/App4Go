package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EmplicitIntent_0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_0);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null){
                String val1 = extras.getString("val1");
                String val2 = extras.getString("val2");
                Toast.makeText(this, "Values:\n " + val1 + "\n " + val2, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No values passed", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "No data passed yet!", Toast.LENGTH_SHORT).show();
        }
    }

    public void csa(View view) {
        Intent csa = new Intent(getApplicationContext(), ExplicitIntent_1.class);
        csa.putExtra("Value1", "Hi from the creator");
        csa.putExtra("Value2", "Nice to see you here!");
        startActivity(csa);
    }

    public void csa_(View view){
        Intent csa_ = new Intent(this, ExplicitIntent_1.class);
        startActivity(csa_);
    }
}
