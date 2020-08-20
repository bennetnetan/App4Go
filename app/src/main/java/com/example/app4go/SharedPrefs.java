package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefs extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

        textView = this.findViewById(R.id.textView13);
        Button storeinfo = this.findViewById(R.id.button10);
        Button showInfo = this.findViewById(R.id.button11);

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button10:
                        try{
                            Toast.makeText(SharedPrefs.this, "I'm here", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SharedPrefs.this, PrefsActivity.class);
                            startActivity(intent);
                        }catch (Exception e){
                            Toast.makeText(SharedPrefs.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.button11:
                        displaySharedPreferences();
                        break;

                    default:
                        break;
                }
            }
        };
        storeinfo.setOnClickListener(listener);
        showInfo.setOnClickListener(listener);
    }

    private void displaySharedPreferences(){
        try{
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String Username = prefs.getString("username", "Default NickName");
            String passwd = prefs.getString("password", "Default Passsword");
            boolean checkbox = prefs.getBoolean("checkbox", false);
            String listPrefs =  prefs.getString("listpref", "Default list prefs");

            StringBuilder builder = new StringBuilder();
            builder.append("Username: " + Username + "\n");
            builder.append("Password: " + passwd + "\n");
            builder.append("Keep me logged in: " + String.valueOf(checkbox) + "\n");
            builder.append("List preference: " + listPrefs);
            textView.setText(builder.toString());
        } catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
