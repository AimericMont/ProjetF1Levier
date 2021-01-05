package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {

                teams.removeplayer(position);
                listItems.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void addClick(View view) {



        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String name = editText.getText().toString();

        editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        String firstName = editText.getText().toString();

        Spinner spinner = (Spinner) findViewById(R.id.spinner) ;
        int level =Integer.parseInt(spinner.getSelectedItem().toString());

        System.out.print("bonjour");
        teams.addPlayer(name,firstName,level);


        listItems.add(String.format("%d - %s %s   lvl :%d", teams.getNbPlayer(), name, firstName, level));
        adapter.notifyDataSetChanged();

        ListView mListView = (ListView)findViewById(R.id.playerlistView);



    }

    public void endAddPlayer(View view) {

        //toRemove
        teams.addPlayer("j1","firstName1",1);
        teams.addPlayer("j2","firstName2",2);
        teams.addPlayer("j3","firstName3",3);
        teams.addPlayer("j4","firstName4",4);
        teams.addPlayer("j5","firstName5",5);
        teams.addPlayer("j6","firstName6",6);
        teams.addPlayer("j7","firstName7",7);
        teams.addPlayer("j8","firstName8",8);
        teams.addPlayer("j9","firstName9",9);

        teams.makeTeam();

        Intent intent = new Intent(this, teamView.class);

        intent.putExtra("teamList", teams);

        startActivity(intent);

    }
}