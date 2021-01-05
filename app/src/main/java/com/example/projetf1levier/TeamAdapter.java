package com.example.projetf1levier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TeamAdapter extends BaseAdapter {
    teamList m_teams;

    LayoutInflater inflter;


    private Context m_context;

    public TeamAdapter(Context context,teamList teams)
    {
        m_context=context;
        inflter = (LayoutInflater.from(context));
        m_teams=teams;
    }

    @Override
    public int getCount() {
        return m_teams.getNbTeam();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflter.inflate(R.layout.grid_view_team, null); // inflate the layout
        //convertView = LayoutInflater.from(m_context).inflate(R.layout.activity_team_view, parent, false);;

        String name=m_teams.getListOfTeam().get(position).getPlayerList().get(1).getName();

        player p1=m_teams.getListOfTeam().get(position).getPlayerList().get(1);
        player p2=m_teams.getListOfTeam().get(position).getPlayerList().get(2);

        TextView nameP1 = (TextView) convertView.findViewById(R.id.nameP1);
        TextView nameP2 = (TextView) convertView.findViewById(R.id.nameP2);
        TextView firstNameP1 = (TextView) convertView.findViewById(R.id.firstNameP1);
        TextView firstNameP2 = (TextView) convertView.findViewById(R.id.firstNameP2);
        TextView levelP1 = (TextView) convertView.findViewById(R.id.levelP1);
        TextView levelP2 = (TextView) convertView.findViewById(R.id.levelP2);

        nameP1.setText(p1.getName());
        nameP2.setText(p2.getName());
        firstNameP1.setText(p1.getFirstName());
        firstNameP2.setText(p2.getFirstName());
        levelP1.setText(String.valueOf(p1.getLevel()));
        levelP2.setText(String.valueOf(p2.getLevel()));
        return convertView;
    }
}
