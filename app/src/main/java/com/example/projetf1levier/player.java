package com.example.projetf1levier;

/*
*Class player
* have name, firstName and level
 */
public class player implements Comparable {
    String m_name;
    String m_firstName;
    int m_level;

    /*
    *Constructor
    * take name firstName and level of the player
    *
     */
    public player(String _name, String _firstName, int _level)
    {
        m_name=_name;
        m_firstName=_firstName;
        m_level=_level;
    }


    /*
    *getter
     */
    public int getLevel() {
        return m_level;
    }


    @Override
    public int compareTo(Object p) {
        int comparLevel=((player)p).getLevel();
        /* For Ascending order*/
        return this.m_level-comparLevel;

    }
}
