package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class IntroServices extends AppCompatActivity {

    Button btn_start, btn_stop, btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_services);

        btn_start = this.findViewById(R.id.button7);
        btn_stop = this.findViewById(R.id.button8);
        btn_next = this.findViewById(R.id.button9);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(IntroServices.this, MyService.class));
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(IntroServices.this, MyService.class));
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroServices.this, ServicesTwo.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View src) {
        switch(src.getId()){
            case R.id.button7:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.button8:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.button9:
                Intent intent = new Intent(this, ServicesTwo.class);
                startActivity(intent);
                break;
        }
    }
}
