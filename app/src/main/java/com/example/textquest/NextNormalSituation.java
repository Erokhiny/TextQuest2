package com.example.textquest;

public class NextNormalSituation extends NextSituation{
    @Override
    protected Situation CreateCurrentSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance){
        return new NormalSituation(subject, text, variants, dh, ds, dl, chance);
    }
}
