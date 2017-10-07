package mis49m.com.customadapter2;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<SocialNetwork> socialNetworks;

    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder{

        // each data item is just a string in this case
        public TextView name;
        public ImageView image;
        public CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

    public MyAdapter(ArrayList<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, final int position) {
        final SocialNetwork socialNetwork = socialNetworks.get(position);
        viewHolder.name.setText(socialNetwork.getName());
        viewHolder.image.setImageResource(socialNetwork.getImage());
        viewHolder.checkBox.setChecked(socialNetwork.isChecked());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                socialNetwork.setChecked(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return socialNetworks.size();
    }


}
