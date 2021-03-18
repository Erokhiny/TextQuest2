package com.example.textquest;

import android.widget.Button;
import android.widget.TextView;

public abstract class Situation {
    public static class Variant{
        Situation nextSituation;
        String text;

        public Variant(Situation nextSituation, String text){
            this.nextSituation=nextSituation;
            this.text=text;
        }
    }
    String title,text;
    int dH,dS,dL, chance;
    Variant[] direction;
    public abstract void getInfluence();
    public abstract void startSituation(TextView txt, Button b0, Button b1, Button b2);
    public Situation rollTheDices(){
        int a = (MainActivity.random.nextInt()%20+20)%20;
        if(a+Character.getInstance().L<=chance){
            System.out.println(a);
            return direction[0].nextSituation;
        }
        else{
            return this;
        }
    }
}
