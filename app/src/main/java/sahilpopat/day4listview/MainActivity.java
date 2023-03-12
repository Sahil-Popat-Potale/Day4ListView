package sahilpopat.day4listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] items_list = {
            "Main Character from OG series 'NARUTO'",
            "Second Main Character from 'NARUTO'",
            "Sake brothers from 'One Piece",
            "Main Character of Famous Anime 'One Piece'",
            "Hero's & Villein of Demon Slayer",
            "Main Characters of Fulllmetal Alchemist",
            "Main Character / Villein of Death Note",
            "Hero and main character of Sword Art Online",
            "Hero's of Hunter X Hunter",
            "Powerful group of people in Jujutsu Kaisen",
            "Protagonist of Anime Dr. Stone",
            "Half Human and Half demon Denji the 'Chainsaw Man'",
            "Family of World class SPY, Assassin and a psychic girl with her psychic pet "

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<CustomClass> items = new ArrayList<>();
        items.add(new CustomClass("Naruto Uzumaki","Main Character from OG series 'NARUTO'",R.drawable.naruto));
        items.add(new CustomClass("Sasuke Uchiha","Second Main Character from 'NARUTO'",R.drawable.sasuke));
        items.add(new CustomClass("ACE, Sabo, Luffy","Sake brothers from 'One Piece",R.drawable.acesabo));
        items.add(new CustomClass("Monkey D. Luffy","Main Character of Famous Anime 'One Piece'",R.drawable.luffy));
        items.add(new CustomClass("Demon Slayer: Kimetsu no Yaiba","Hero's & Villein of Demon Slayer",R.drawable.demonslayer));
        items.add(new CustomClass("Fullmetal Alchemist","Main Characters of Fulllmetal Alchemist",R.drawable.fullmetal));
        items.add(new CustomClass("Death Note","Main Character / Villein of Death Note",R.drawable.deathnote));
        items.add(new CustomClass("Sword Art Online","Hero and main character of Sword Art Online",R.drawable.sao));
        items.add(new CustomClass("Hunter X Hunter","Hero's of Hunter X Hunter",R.drawable.hunterxhunter));
        items.add(new CustomClass("Jujutsu Kaisen","Powerful group of people in Jujutsu Kaisen",R.drawable.jujutsukaisen));
        items.add(new CustomClass("Dr. Stone","Protagonist of Anime Dr. Stone",R.drawable.drstone));
        items.add(new CustomClass("Chainsaw Man","Half Human and Half demon Denji the 'Chainsaw Man'",R.drawable.chainsawman));
        items.add(new CustomClass("Spy X Family","Family of World class SPY, Assassin and a psychic girl with her psychic pet",R.drawable.spyxfamily));



        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,items);

        ListView listView = findViewById(R.id.list_view);

        listView.setDivider(null);
        listView.setAdapter(customAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_alert);
                TextView text = dialog.findViewById(R.id.alert_text_view);
                Button hide = dialog.findViewById(R.id.hide_btn);



                text.setText(items_list[position]);

                dialog.show();



                hide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}