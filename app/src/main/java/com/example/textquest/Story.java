package com.example.textquest;

import android.widget.Button;
import android.widget.TextView;

public class Story {

    public Situation current_situation;
    public static Character character;

    Story(TextView txt, Button b0, Button b1, Button b2) {
        current_situation = MainActivity.saved_situations[0];
        current_situation.startSituation(txt, b0, b1, b2);
    }

    public void go(int num, TextView txt, Button b0, Button b1, Button b2) {
        current_situation = current_situation.direction[num].nextSituation.rollTheDices();
        current_situation.getInfluence();
        if(this.isEnd()){
            current_situation.startSituation(txt, b0, b1, b2);
        }
        else{
            current_situation.startSituation(txt, b0, b1, b2);
        }
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
