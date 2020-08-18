package com.example.app4go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class searchview extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);

        searchView = this.findViewById(R.id.SV_);
        listView = this.findViewById(R.id.lV_Search);

        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavana");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        stringArrayAdapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, list);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String txt = stringArrayAdapter.getItem(position).toString();
                    Toast.makeText(searchview.this, txt, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(searchview.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.contains(query)) {
                    stringArrayAdapter.getFilter().filter(query);
                } else {
                    Toast.makeText(searchview.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                if (list.contains(newText)) {
//                    stringArrayAdapter.getFilter().filter(newText);
//                }
                return false;
            }
        });
    }
}
