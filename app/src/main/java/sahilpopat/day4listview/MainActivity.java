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
            "Learn Android From Scratch",
            "Build very nice Web Apps",
            "Learn Android From Scrath",
            "Build Very Nice Web Apps",
            "Start New Job Path as a Web Hacker",
            "Build Very Nice Personality and Learn More",
            "Build Very Nice ios Apps",
            "Design Very Nice Web Apps",
            "Design Android Apps in photoshop",
            "use the most puoplar App Development Fraemwork to build you apps",
            "How to markte youe website in the Internet",
            "Download any tyes of viedos with one click",
            "how to write very clear code for android"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<CustomClass> items = new ArrayList<>();
        items.add(new CustomClass("Naruto Uzumaki","Learn Android From Scratch",R.drawable.naruto));
        items.add(new CustomClass("Sasuke Uchiha","Build very nice Web Apps",R.drawable.sasuke));
        items.add(new CustomClass("ACE, Sabo, Luffy","Learn Android From Scrath",R.drawable.acesabo));
        items.add(new CustomClass("Monkey D. Luffy","Build Very Nice Web Apps",R.drawable.luffy));
        items.add(new CustomClass("Roronoa Zoro","Start New Job Path as a Web Hacker",R.drawable.zoro));
        items.add(new CustomClass("Human Development","Build Very Nice Personality and Learn More ",R.drawable.fullmetal));
        items.add(new CustomClass("ios Development","Build Very Nice ios Apps",R.drawable.deathnote));
        items.add(new CustomClass("Kirito","Design Very Nice Web Apps",R.drawable.sao));
        items.add(new CustomClass("Android App Design","Design Android Apps in photoshop",R.drawable.hunterxhunter));
        items.add(new CustomClass("Andriod Fraemwork","use the most puoplar App Development Fraemwork to build you apps",R.drawable.jujutsukaisen));
        items.add(new CustomClass("Web Markting","How to markte youe website in the Internet",R.drawable.drstone));
        items.add(new CustomClass("Videos Download","Download any tyes of viedos with one click",R.drawable.chainsawman));
        items.add(new CustomClass("Learn to Code","how to write very clear code for android",R.drawable.spyxfamily));



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