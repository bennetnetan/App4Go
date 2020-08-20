package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.PendingIntent.getBroadcast;

public class AlarmMan extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_man);

        start = this.findViewById(R.id.buttonAl);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });
    }

    public void startAlert(){
        EditText editText = this.findViewById(R.id.editTextAl);
        int i = Integer.parseInt(editText.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReciever.class);
        PendingIntent pendingIntent = getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm Set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }
}
