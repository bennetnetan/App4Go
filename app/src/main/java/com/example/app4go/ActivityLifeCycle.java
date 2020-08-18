package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("Lifecycle", "onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy invoked");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Lifecycle", "onResume invoked");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Lifecycle", "onPause invoked");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Lifecycle", "onRestart invoked");
    }
}
