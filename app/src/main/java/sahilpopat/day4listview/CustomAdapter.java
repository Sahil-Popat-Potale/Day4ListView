package sahilpopat.day4listview;

import android.content.Context;
import android.content.pm.LabeledIntent;
//import android.support.annotation.NonNull;
import androidx.annotation.NonNull;
//import android.support.annotation.Nullable;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CustomClass> {


    public CustomAdapter(@NonNull Context context, ArrayList<CustomClass> resource) {
        super(context, 0, resource);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item, parent, false);


        CustomClass item = getItem(position);


        TextView title = convertView.findViewById(R.id.title);
        title.setText(item.getTitle());


        TextView desc = convertView.findViewById(R.id.description);
        desc.setText(item.getDesc());


        ImageView imageView = convertView.findViewById(R.id.image_view);
        imageView.setImageResource(item.getImage_res());


        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.custom_listview_animation);
        convertView.startAnimation(animation);

        return convertView;
    }
}
