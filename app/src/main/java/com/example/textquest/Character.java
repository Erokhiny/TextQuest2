package com.example.textquest;

public class Character {
    public int H;
    public int S;
    public int L;
    private static Character instance;

    public static Character getInstance(){
        if(instance==null){
            instance=new Character();
        }
        return instance;
    }

    public void deleteCharacter(){
        instance = null;
    }

    private Character() {
        H = 100;
        S = 100;
        L = 1;
    }
}
