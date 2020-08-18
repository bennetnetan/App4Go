package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class getresult extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_result);

        editText = this.findViewById(R.id.editText2);
        button = this.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                if (message.length() < 3) {
                    Toast.makeText(getresult.this, "Input longer text", Toast.LENGTH_SHORT).show();
                } else if (message.length() > 250) {
                    Toast.makeText(getresult.this, "Input shorter length of text", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", message);
                    setResult(2, intent);
                    finish();
                }
            }
        });
    }
}
