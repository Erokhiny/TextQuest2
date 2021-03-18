package com.example.textquest;

import android.widget.Button;
import android.widget.TextView;

public class EnderSituation extends Situation{
    public EnderSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance) {
        this.title=subject;
        this.text=text;
        this.chance=chance;
        dH=dh;
        dS=ds;
        dL=dl;
        direction=new Variant[variants+1];
    }

    @Override
    public void getInfluence(){
        Character.getInstance().H+=dH;
        Character.getInstance().S+=dS;
        Character.getInstance().L+=dL;
    }

    @Override
    public void startSituation(TextView txt, Button b0, Button b1, Button b2){
        txt.setText(this.text);
        b2.setVisibility(Button.GONE);
        b1.setVisibility(Button.GONE);
        b0.setVisibility(Button.GONE);
    }
}
