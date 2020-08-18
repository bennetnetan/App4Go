package com.example.app4go;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class option_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        try {
            Toolbar toolbar = this.findViewById(R.id.toolbar);
            setSupportActionBar(this.<androidx.appcompat.widget.Toolbar>findViewById(R.id.toolbar));
        } catch (Exception e) {
//            Snackbar.make(getCurrentFocus(), e.toString(), Snackbar.LENGTH_LONG);
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        try {
            switch (id) {
                case R.id.item1:
                    Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.item2:
                    Toast.makeText(this, "Item 2 is selected", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.item3:
                    Toast.makeText(this, "Item 3 is selected", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    return super.onOptionsItemSelected(item);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
