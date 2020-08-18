package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivtyForResult extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activty_for_result);

        textView = this.findViewById(R.id.textView6);
        button = this.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(StartActivtyForResult.this, getresult.class);
                    startActivityForResult(intent, 2);
                } catch (Exception e) {
                    Toast.makeText(StartActivtyForResult.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            String message = data.getStringExtra("MESSAGE");
            textView.setText(message);
        }
    }
}
