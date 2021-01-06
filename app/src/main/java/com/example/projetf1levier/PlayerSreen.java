package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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

                ImageButton deleteIcon = (ImageButton) findViewById(R.id.deleteIcon);
                deleteIcon.setVisibility(view.VISIBLE);
                teams.removeplayer(position);
                listItems.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void deletePlayer()
    {

    }

    public void addClick(View view) {



        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String name = editText.getText().toString();

        editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        String firstName = editText.getText().toString();


        Spinner spinner = (Spinner) findViewById(R.id.spinner) ;
        int level =Integer.parseInt(spinner.getSelectedItem().toString());

        teams.addPlayer(name,firstName,level);

        TextView nbPlayer = (TextView) findViewById(R.id.nbPlayer);
        nbPlayer.setText(String.valueOf(teams.getNbPlayer()));


        listItems.add(String.format("%s %s   lvl :%d", name, firstName, level));
        adapter.notifyDataSetChanged();

        ListView mListView = (ListView)findViewById(R.id.playerlistView);



    }

    public void endAddPlayer(View view) {

        //toRemove
        teams.addPlayer("j1","firstName1",1);
        teams.addPlayer("j2","firstName2",1);
        teams.addPlayer("j3","firstName3",1);
        teams.addPlayer("j4","firstName4",1);
        teams.addPlayer("j5","firstName18",1);
        teams.addPlayer("j6","firstName6",1);
        teams.addPlayer("j7","firstName7",1);
        teams.addPlayer("j8","firstName8",1);
        teams.addPlayer("j9","firstName9",1);

        teams.addPlayer("j1","firstName1",1);
        teams.addPlayer("j2","firstName2",1);
        teams.addPlayer("j3","firstName3",1);
        teams.addPlayer("j4","firstName4",1);
        teams.addPlayer("j5","firstName5",1);
        teams.addPlayer("j6","firstName6",1);
        teams.addPlayer("j7","firstName7",1);
        teams.addPlayer("j8","firstName8",1);
        teams.addPlayer("j9","firstName9",1);

        teams.addPlayer("j1","firstName1",1);
        teams.addPlayer("j2","firstName2",1);
        teams.addPlayer("j3","firstName3",1);
        teams.addPlayer("j4","firstName4",1);
        teams.addPlayer("j5","firstName5",1);
        teams.addPlayer("j6","firstName6",1);
        teams.addPlayer("j7","firstName7",1);
        teams.addPlayer("j8","firstName8",1);
        teams.addPlayer("j9","firstName9",1);

        teams.makeTeam();

        Intent intent = new Intent(this, teamView.class);

        intent.putExtra("teamList", teams);

        startActivity(intent);

    }
}