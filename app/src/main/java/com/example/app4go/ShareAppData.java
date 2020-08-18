package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShareAppData extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_app_data);

        button = this.findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject Here");
                    String app_url = "https://play.google.com/store/apps/details?id=my.example.netan";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, app_url);
                    startActivity(Intent.createChooser(shareIntent,"Share via: "));
                } catch (Exception e) {
                    Toast.makeText(ShareAppData.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
