package com.example.projetf1levier;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;

public class teamList implements Parcelable {

    ArrayList<team> m_listOfTeam;
    //ArrayList<player> m_listOfPlayer;
    ArrayList<player> m_listOfPlayer;


    public teamList(PlayerSreen screen)
    {
        m_listOfTeam= new ArrayList<team>();
        ArrayList<player> m_listOfPlayer= new ArrayList<player> ();
    }

    public void addPlayer(player _p)
    {
        m_listOfPlayer.add(_p);
    }

    public void addPlayer(String _name, String _firstName, int _level)
    {
        addPlayer(new player(_name,_firstName,_level));
    }

    public int getNbPlayer()
    {
        return m_listOfPlayer.size();
    }

    public void makeTeam()
    {
        int nbPlayer=getNbPlayer();
        int nbTeam= (nbPlayer%3 != 0) ? nbPlayer/3 : nbPlayer/3 +1;

        Collections.sort(m_listOfPlayer);

        for (int i=0;i<nbTeam;i++)
        {
            m_listOfTeam.add(new team());
        }


        for(int p=0;p<nbPlayer;p++)
        {
            m_listOfTeam.get(p).addPlayer(m_listOfPlayer.get(p));
        }
    }

    public ArrayList<team> getListOfTeam() {
        return m_listOfTeam;
    }

    public int genbTeam()
    {
        return m_listOfTeam.size();
    }


    protected teamList(Parcel in) {
        if (in.readByte() == 0x01) {
            m_listOfTeam = new ArrayList<team>();
            in.readList(m_listOfTeam, team.class.getClassLoader());
        } else {
            m_listOfTeam = null;
        }
        if (in.readByte() == 0x01) {
            m_listOfPlayer = new ArrayList<player>();
            in.readList(m_listOfPlayer, player.class.getClassLoader());
        } else {
            m_listOfPlayer = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (m_listOfTeam == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(m_listOfTeam);
        }
        if (m_listOfPlayer == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(m_listOfPlayer);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<teamList> CREATOR = new Parcelable.Creator<teamList>() {
        @Override
        public teamList createFromParcel(Parcel in) {
            return new teamList(in);
        }

        @Override
        public teamList[] newArray(int size) {
            return new teamList[size];
        }
    };

}


