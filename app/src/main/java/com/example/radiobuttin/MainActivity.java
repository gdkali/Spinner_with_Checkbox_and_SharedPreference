package com.example.radiobuttin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        final String[] select_planets =
                getApplicationContext().getResources().getStringArray(R.array.planets_array);
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<>();

        for (String s : select_planets) {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setTitle(s);
            categoryModel.setSelected(false);
            categoryModelArrayList.add(categoryModel);
        }

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, 0, categoryModelArrayList);
        spinner.setAdapter(myAdapter);

        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        Map<String, ?> category = sharedPreferences.getAll();

        Toast.makeText(getApplicationContext(), "" + category, Toast.LENGTH_LONG).show();


    }
}
