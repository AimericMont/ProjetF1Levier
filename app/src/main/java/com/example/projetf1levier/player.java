package com.example.projetf1levier;

/*
*Class player
* have name, firstName and level
 */

public class player {
    String name;
    String firstName;
    int level;

    /*
    *Constructor
    * take name firstName and level of the player
    *
     */
    public player(String _name, String _firstName, int _level)
    {
        name=_name;
        firstName=_firstName;
        level=_level;
    }

    /*
    *getter
     */
    public int getLevel() {
        return level;
    }
}
