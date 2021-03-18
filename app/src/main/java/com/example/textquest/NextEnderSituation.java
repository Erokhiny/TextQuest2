package com.example.textquest;

public class NextEnderSituation extends NextSituation {
    @Override
    protected Situation CreateCurrentSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance){
        return new EnderSituation(subject, text, variants, dh, ds, dl, chance);
    }
}
