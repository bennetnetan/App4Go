package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class SQLiteS extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText editText;
    Button button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_s);

        button14 = this.findViewById(R.id.button14);
        editText = this.findViewById(R.id.editText5);
        spinner = this.findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        loadSpinnerData();

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = editText.getText().toString();

                if (label.trim().length() > 0) {
                    DatabaseHandler handler = new DatabaseHandler(SQLiteS.this);
                    handler.insertLabel(label);

                    //Making input field text to blank
                    editText.setText("");

                    //Hiding the Keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    //Loading the spinner with newly loaded data
                    loadSpinnerData();
                } else {
                    Toast.makeText(SQLiteS.this, "Please Enter the label name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Function to load the Spinner data from the SQLite Database
    private void loadSpinnerData(){
        DatabaseHandler db = new DatabaseHandler(this);
        List<String> labels = db.getAllLabels();

        //creating the adapter for the spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labels);

        //Dropdown layout style - listView with RadioButton
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Attaching the dataAdapter to the Spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
