package com.example.textquest;

import android.widget.Button;
import android.widget.TextView;

public class NormalSituation extends Situation {

    public NormalSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance) {
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
        b2.setVisibility(Button.VISIBLE);
        b1.setVisibility(Button.VISIBLE);
        b0.setVisibility(Button.VISIBLE);
        if(direction.length<4)
            b2.setVisibility(Button.GONE);
        else
            b2.setText(direction[3].text);
        if(direction.length<3)
            b1.setVisibility(Button.GONE);
        else
            b1.setText(direction[2].text);
        if(direction.length<2)
            b0.setVisibility(Button.GONE);
        else
            b0.setText(direction[1].text);
    }

}
