package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlayerSreen extends AppCompatActivity {

    private teamList teams=new teamList(this);


    ArrayList<String> listItems=new ArrayList<String>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_sreen);

        ListView listView = (ListView)findViewById(R.id.playerlistView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    public void addClick(View view) {
        // Do something in response to button

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String name = editText.getText().toString();

        editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        String firstName = editText.getText().toString();

        System.out.print("bonjour");
        teams.addPlayer(new player(name,firstName,1));


        listItems.add(teams.getNbPlayer()+" - "+name+" " +firstName  + "");
        adapter.notifyDataSetChanged();

        ListView mListView = (ListView)findViewById(R.id.playerlistView);

    }

    public void endAddPlayer(View view) {
        teams.makeTeam();

        Intent intent = new Intent(this, teamView.class);

        intent.putExtra("teamList",teams.getListOfTeam());
        startActivity(intent);

    }
}