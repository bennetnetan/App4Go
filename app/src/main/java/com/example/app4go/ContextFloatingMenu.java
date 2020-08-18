package com.example.app4go;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextFloatingMenu extends AppCompatActivity {

    ListView listView;
    String contacts[] = {"Ajay", "Sunjay", "Craig", "Eddy", "Thomas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_floating_menu);

        listView = this.findViewById(R.id.liView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);
        //Register the ListView for the Context Menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main0, menu);
        menu.setHeaderTitle("Select the Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.call){
            Toast.makeText(this, "Calling Code", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.sms) {
            Toast.makeText(this, "Sending SMS code", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return false;
    }
}
