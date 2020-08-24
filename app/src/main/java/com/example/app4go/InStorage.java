package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InStorage extends AppCompatActivity {

    EditText eTData, eTFileName;
    Button buttonSave, buttonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_storage);

        eTData = this.findViewById(R.id.editText3);
        eTFileName = this.findViewById(R.id.editText4);

        buttonRead = this.findViewById(R.id.button12);
        buttonSave = this.findViewById(R.id.button13);

        //Perform action on the read button
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = eTFileName.getText().toString();
                String data = eTData.getText().toString();

                FileOutputStream fileOutputStream;

                try {
                    fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    //defailt mode is PRIVATE can be APPEND etc.
                    fileOutputStream.write(data.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(InStorage.this, fileName + " saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {e.printStackTrace();}
            }
        });

        //Perform action on the Read button

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = eTFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();

                try {
                    //Attaching the BufferedReader to the FileInputStream by the help of InputStreamReader
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
                    String inputString;
                    //Reading the data line by line and sorting it into the stringBuffer
                    while ((inputString = inputReader.readLine()) != null) {
                        stringBuffer.append(inputString + "\n");
                    }
                } catch (IOException e)   {
                    e.printStackTrace();
                }

                //Displaying the data on the toast
                Toast.makeText(InStorage.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
