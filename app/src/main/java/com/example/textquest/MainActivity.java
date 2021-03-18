package com.example.textquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static Situation[] saved_situations = new Situation[10];
    public static Story story;
    public static Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button)findViewById(R.id.b1);
        Button b0 = (Button)findViewById(R.id.b0);
        Button b2 = (Button)findViewById(R.id.b2);
        Button bret = (Button)findViewById(R.id.bret);
        TextView txt =(TextView)findViewById(R.id.textView);
        TextView atxt =(TextView)findViewById(R.id.Atext);
        TextView rtxt =(TextView)findViewById(R.id.Rtext);
        TextView ktxt =(TextView)findViewById(R.id.Ktext);
        add_some_situations();
        story = new Story(txt, b0, b1, b2);
        statusUpdate(atxt, ktxt, rtxt);
        b0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               story.go(1, txt, b0, b1, b2);
               statusUpdate(atxt, ktxt, rtxt);}
        });
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story.go(2, txt, b0, b1, b2);
                statusUpdate(atxt, ktxt, rtxt);}
        });
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story.go(3, txt, b0, b1, b2);
                statusUpdate(atxt, ktxt, rtxt);}
        });
        bret.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story = new Story(txt, b0, b1, b2);
                Character.getInstance().deleteCharacter();
                statusUpdate(atxt, ktxt, rtxt);
            }
        });

//        while (true) {
//            manager.A += story.current_situation.dA;
//            manager.K += story.current_situation.dK;
//            manager.R += story.current_situation.dR;
//            System.out.println("=====\nКарьера:" + manager.K + "\tАктивы:"
//                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
//            System.out.println("============="
//                    + story.current_situation.subject + "==============");
//            System.out.println(story.current_situation.text);
//            if (story.isEnd()) {
//                System.out
//                        .println("====================the end!===================");
//                return;
//            }
//        }
    }
    public void statusUpdate(TextView a, TextView k, TextView r){
        a.setText(((Integer)Character.getInstance().H).toString());
        r.setText(((Integer)Character.getInstance().S).toString());
        k.setText(((Integer)Character.getInstance().L).toString());
    }
    private void add_some_situations(){
        saved_situations[0]= NextSituation.getInstance().CreateSituation("Неприятное пробуждение", "ВЫ просыпаетесь от ощущения,"
            +" как буд-то за вами что-то следит, вам с трудом удаётся вспомнить, даже кто вы такой и малую часть вчерашних событий,"
            +" кажется вы молодой гном, ничего особенно не умеющий, кроме как акуратно переставлять склянки в магазине вашего дядюшки."
            +" кажется вчера ваш постоянный покупатель Огрен предложил вам обмыть рождение его сына, и вы вместе с его подручными пили самый странный алкоголь в вашей жизни, обмениваясь историями\n",
                1, -10, -10, 1, 0);
        saved_situations[1]= NextSituation.getInstance().CreateSituation("Странный гость", "С трудом проползя до фонтанчика,"
                +" что бы снять сушняк, вы кажется понимаете, чо именно разбудило вас сегодня. В углу комнаты клубится странный туман,"
                +" кажется он приближается, всё отчётливее вы понимаете, что это что-то походит на силуэт монашки со странной зияющей дырой в центре груди.\n",
                3, 0, -5, 0, 0);
        saved_situations[2]= NextSituation.getInstance().CreateSituation("Неудачное падение", "Не совладав с непослушным организмом,"
                +" и невероятной головной болью ты распластался на земле, а сущность монашки, дотянувшись до тебя, попыталась выкинуть твою душу из этого тела\n",
                3, 0, -5, -1, 0);
        saved_situations[3]= NextSituation.getInstance().CreateSituation("Истовая молитва", "В какой-то момент молясь ты зажмуриваешь глаза,"
                +" а открыв их кажется, буд-то монашку сжало и она с истошным криком начала растворяться буквально перед твоим носом.\n",
                2, 0, +5, 1, 0);
        saved_situations[4]= NextSituation.getInstance().CreateSituation("Крепкая воля", "Твоя воля подвергается серьёзной проверке,"
                +" тебе кажется, буд-то бы твою голову сдавливают тиски, но ты продолжаешь бороться и эта тварь отступает, пропадая из этого мира.\n",
                2, 0, +5, 5, 8);
        saved_situations[5]= NextSituation.getInstance().CreateSituation("Бесплотный дух", "Твоя воля подвергается серьёзной проверке,"
                +" тебе кажется, буд-то бы твою голову сдавливают тиски, но ты продолжаешь бороться однако тварь выкидывает тебя из твоего тела"
                +" после чего ритуально убивает твоё тело, твой бесплотный дух не на долгопережил тело и в следующий момент ты осознаёшь себя уже в тёплых руках, снимающих с тебя слои," +
                "один за другим, до тех пор, пока ты не очишаешься от собственного же естества, становясь частью неодушевлённного в этом мире.\n"
                +"Конец игры",
                0, -100, 0, 0, 0);
        saved_situations[6]= NextSituation.getInstance().CreateSituation("Последующие приключения", "Поговорив с Огреном ты выясняешь, что"
                +" остальные твои собеседники мертвы, вы решаете наведаться к монашке, продавшей вчерашнюю настойку и спросить с неё, за жизни ваших товарищей.\n"
                +"Конец игры",
                0, 0, +5, 5, 0);
        saved_situations[7]= NextSituation.getInstance().CreateSituation("Простая жизнь", "Ты решил забыть об этом случае и продолжить вести свою обычную жизнь,"
                +" собственно это и происходит.\n"
                +"Конец игры",
                0, 0, +5, 0, 0);
        saved_situations[0].direction[1] = new Situation.Variant(saved_situations[1], "Утолить всеобъемлющую жажду");
        saved_situations[1].direction[1] = new Situation.Variant(saved_situations[2], "Накинуться на это существо и попытаться придушить");
        saved_situations[1].direction[2] = new Situation.Variant(saved_situations[2], "Попытаться убежать");
        saved_situations[1].direction[3] = new Situation.Variant(saved_situations[3], "Попробовать прогнать его малитвой великому Камню");
        saved_situations[2].direction[1] = new Situation.Variant(saved_situations[4], "Усиленно сопротивляться");
        saved_situations[2].direction[2] = new Situation.Variant(saved_situations[3], "Истово молиться Камню");
        saved_situations[2].direction[3] = new Situation.Variant(saved_situations[5], "Не сопротивляться");
        saved_situations[3].direction[1] = new Situation.Variant(saved_situations[7], "Забыть об этом как о страшном сне");
        saved_situations[3].direction[2] = new Situation.Variant(saved_situations[6], "Найти Огрена и обсудить случившееся");
        saved_situations[4].direction[0] = new Situation.Variant(saved_situations[5], "");
        saved_situations[4].direction[1] = new Situation.Variant(saved_situations[7], "Забыть об этом как о страшном сне");
        saved_situations[4].direction[2] = new Situation.Variant(saved_situations[6], "Найти Огрена и обсудить случившееся");
    }
}