package com.example.textquest;

public class NextSituation {
    private static NextSituation instance;

    public static NextSituation getInstance(){
        if(instance==null){
            instance=new NextSituation();
        }
        return instance;
    }

    protected Situation CreateCurrentSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance) {
        return null;
    }

    public Situation CreateSituation(String subject, String text, int variants, int dh, int ds, int dl, int chance){
        NextSituation creator= getInstance();
        if(variants==0)
            creator=new NextEnderSituation();
        else
            creator=new NextNormalSituation();
        return creator.CreateCurrentSituation(subject, text, variants, dh, ds, dl, chance);
    }
}
