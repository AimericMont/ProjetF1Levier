package com.example.projetf1levier;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    int m_itemSelected;

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

                m_itemSelected=position;

                ImageButton deleteIcon = (ImageButton) findViewById(R.id.deleteIcon);
                deleteIcon.setVisibility(view.VISIBLE);
                deleteIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageButton deleteIcon = (ImageButton) findViewById(R.id.deleteIcon);
                        deleteIcon.setVisibility(v.INVISIBLE);
                        deletePlayer();
                    }

                });

            }
        });

    }

    public void deletePlayer()
    {
        teams.removeplayer(m_itemSelected);
        listItems.remove(m_itemSelected);
        adapter.notifyDataSetChanged();

        TextView nbPlayer = (TextView) findViewById(R.id.nbPlayer);
        nbPlayer.setText(String.valueOf(teams.getNbPlayer()));
    }

    public void addClick(View view) {

        if (teams.getNbPlayer()==30)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setTitle("Error in add player");

            alertDialogBuilder
                    .setMessage("You can't add more than 30 student")
                    .setCancelable(false)
                    .setPositiveButton("ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });


            AlertDialog alertDialog = alertDialogBuilder.create();

            //show it
            alertDialog.show();
        }
        else {


            EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
            String name = editText.getText().toString();

            editText = (EditText) findViewById(R.id.editTextTextPersonName2);
            String firstName = editText.getText().toString();


            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            int level = Integer.parseInt(spinner.getSelectedItem().toString());

            teams.addPlayer(name, firstName, level);

            TextView nbPlayer = (TextView) findViewById(R.id.nbPlayer);
            nbPlayer.setText(String.valueOf(teams.getNbPlayer()));


            listItems.add(String.format("%s %s   lvl :%d", name, firstName, level));
            adapter.notifyDataSetChanged();

            ListView mListView = (ListView) findViewById(R.id.playerlistView);

        }

    }

    public void endAddPlayer(View view) {

        if (teams.getNbPlayer()%3!=0 || teams.getNbPlayer()==0 )
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setTitle("Erreur sur l'ajout d'un joueur");

            alertDialogBuilder
                    .setMessage("Le nombre de joueur doit etre un multiple de 3")
                    .setCancelable(false)
                    .setPositiveButton("ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });


            AlertDialog alertDialog = alertDialogBuilder.create();

            //show it
            alertDialog.show();
        }
        else {
            //toRemove
            teams.addPlayer("j1", "firstName1", 1);
            teams.addPlayer("j2", "firstName2", 1);
            teams.addPlayer("j3", "firstName3", 1);
            teams.addPlayer("j4", "firstName4", 1);
            teams.addPlayer("j5", "firstName18", 1);
            teams.addPlayer("j6", "firstName6", 1);
            teams.addPlayer("j7", "firstName7", 1);
            teams.addPlayer("j8", "firstName8", 1);
            teams.addPlayer("j9", "firstName9", 1);

            teams.addPlayer("j1", "firstName1", 1);
            teams.addPlayer("j2", "firstName2", 1);
            teams.addPlayer("j3", "firstName3", 1);
            teams.addPlayer("j4", "firstName4", 1);
            teams.addPlayer("j5", "firstName5", 1);
            teams.addPlayer("j6", "firstName6", 1);
            teams.addPlayer("j7", "firstName7", 1);
            teams.addPlayer("j8", "firstName8", 1);
            teams.addPlayer("j9", "firstName9", 1);

            teams.addPlayer("j1", "firstName1", 1);
            teams.addPlayer("j2", "firstName2", 1);
            teams.addPlayer("j3", "firstName3", 1);
            teams.addPlayer("j4", "firstName4", 1);
            teams.addPlayer("j5", "firstName5", 1);
            teams.addPlayer("j6", "firstName6", 1);
            teams.addPlayer("j7", "firstName7", 1);
            teams.addPlayer("j8", "firstName8", 1);
            teams.addPlayer("j9", "firstName9", 1);

            teams.makeTeam();

            Intent intent = new Intent(this, teamView.class);

            intent.putExtra("teamList", teams);

            startActivity(intent);
        }

    }
}