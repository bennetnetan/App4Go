package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] hlinks = {"View Stub", "Tab Layout", "TabLayout with FrameLayout", "Searchview",
            "Searchview on Toolbar", "Activity Life Cycle", "Implicit intent", "Explicit intent",
            "Start Activity For Result", "Share App Data (ACTION_SEND)", "Option Menu Example",
            "Context or Floating Menu", "Popup Menu", "Introduction to Android services",
            "Alarm Manager Example", "Android Preferences"};
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            textView = this.findViewById(R.id.tV_list);
            listView = this.findViewById(R.id.m_);
            //populate the listView
            arrayAdapter = new ArrayAdapter<>(this, R.layout.list_, R.id.tV_list, hlinks);
            listView.setAdapter(arrayAdapter);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String txt = arrayAdapter.getItem(position).toString();
                try {
                    if (position == 0) {
                        shift(viewstub.class);
                    } else if (position == 1) {
                        shift(tablayout.class);
                    } else if (position == 2) {
                        shift(tablayoutwithFrameLayout.class);
                    } else if (position == 3) {
                        shift(searchview.class);
                    } else if (position == 4) {
                        shift(searhviewOnToolbar.class);
                    } else if (position == 5) {
                        shift(ActivityLifeCycle.class);
                    } else if (position == 6) {
                        shift(ImplicitIntent.class);
                    } else if (position == 7) {
                        shift(EmplicitIntent_0.class);
                    } else if (position == 8){
                        shift(StartActivtyForResult.class);
                    } else if (position == 9) {
                        shift(ShareAppData.class);
                    } else if (position == 10) {
                        //shift(option_menu.class);
                    } else if (position == 11){
                        shift(ContextFloatingMenu.class);
                    } else if (position == 12){
                        shift(PopUpMenu.class);
                    } else if (position == 13) {
                        shift(IntroServices.class);
                    } else if (position == 14) {
                        shift(AlarmMan.class);
                    } else if (position == 15) {
                        shift(SharedPrefs.class);
                    } else {
                        Toast.makeText(MainActivity.this, "Welcome here!", Toast.LENGTH_SHORT).show();
                    }
                    Snackbar.make(view,"",Snackbar.LENGTH_SHORT);
                    Toast.makeText(MainActivity.this, txt, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void shift(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
