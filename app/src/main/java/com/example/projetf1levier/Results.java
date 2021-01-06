package com.example.projetf1levier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ViewAnimator;


import java.util.ArrayList;
import java.util.List;

public class Results extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Spinner spinner1=(Spinner) findViewById(R.id.spinner2);
        Spinner spinner2=(Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.entityValues, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.stepValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        ListView listView = (ListView)findViewById(R.id.results_view);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    public void validateclic(View view)
    {
        if ()

        listItems.add("Nom:     Prenom:     Temps:");
        adapter.notifyDataSetChanged();
    }
}