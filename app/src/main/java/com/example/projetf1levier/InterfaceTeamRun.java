package com.example.projetf1levier;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class InterfaceTeamRun implements Serializable{
    TextView m_title;
    Button m_buttonStep;
    ImageView m_imageStep;
    ImageView m_imagePlayer;

    /*
     *Constructor
     */
    public InterfaceTeamRun(TextView _title, Button _buttonStep, ImageView _imageStep, ImageView _imagePlayer)
    {
         m_title =_title;
         m_buttonStep=_buttonStep;
         m_imageStep=_imageStep;
         m_imagePlayer=_imagePlayer;
    }



    /*
     *Getter
     */
}
