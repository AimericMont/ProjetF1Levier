package com.example.projetf1levier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class RunAdapter extends BaseAdapter {
    teamList m_teams;

    LayoutInflater inflter;


    private Context m_context;

    public RunAdapter(Context context,teamList teams)
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

        convertView = inflter.inflate(R.layout.run_grid_view, null); // inflate the layout
        //convertView = LayoutInflater.from(m_context).inflate(R.layout.activity_team_view, parent, false);;
        team t=m_teams.getListOfTeam().get(position);

        TextView titlteTeam = (TextView) convertView.findViewById(R.id.title_team);
        ImageView numPlayerTeam = (ImageView) convertView.findViewById(R.id.num_player_team);
        ImageView stepTeam = (ImageView) convertView.findViewById(R.id.step_team);


        numPlayerTeam.setImageResource(m_teams.getImageNum(t.getNumberPlayerRun()));
        stepTeam.setImageResource(m_teams.getImageStep(t.getNumberStepRun()));

        titlteTeam.setText("Equipe " + t.getTeamNumber());


        Button nextstep=(Button) convertView.findViewById(R.id.but_team);

        nextstep.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {
                                            m_teams.getListOfTeam().get(0).nextStepRun();
                                        }
        });

        return convertView;
    }
}
