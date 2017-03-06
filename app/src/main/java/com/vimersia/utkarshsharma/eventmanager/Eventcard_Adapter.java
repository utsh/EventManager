package com.vimersia.utkarshsharma.eventmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by UTKARSH SHARMA on 3/6/2017.
 */

public class Eventcard_Adapter extends RecyclerView.Adapter<Eventcard_Adapter.ViewHolder> {
    ArrayList<HashMap<String, String>> personList;


// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public  class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView EventNameTextView,EventDateTextView,EventTimeTextView,EventVenueTextView;
    public ImageView EventImageView;
    public ViewHolder(View view) {
        super(view);
        EventNameTextView = (TextView) view.findViewById(R.id.event_name_inflate);
        EventDateTextView = (TextView) view.findViewById(R.id.event_date_inflate);
        EventTimeTextView = (TextView) view.findViewById(R.id.event_time_inflate);
        EventVenueTextView = (TextView) view.findViewById(R.id.event_address);
        EventImageView = (ImageView) view.findViewById(R.id.image_card);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                String x =personList.get(position).get("TAG_Name");
                view.getContext().startActivity(new Intent(view.getContext(),
                        Event_Details.class).putExtra("T_NAME",personList.get(position).get("TAG_Name"))
                        .putExtra("T_DATE",personList.get(position).get("TAG_Date"))
                        .putExtra("T_TIME",personList.get(position).get("TAG_Time"))
                        .putExtra("T_Address",personList.get(position).get("TAG_Address"))
                        .putExtra("T_Desc",personList.get(position).get("TAG_Desc"))
                );
            }
        });
    }

}

    // Provide a suitable constructor (depends on the kind of dataset)
    public Eventcard_Adapter(ArrayList<HashMap<String, String>> myDataset) {
        personList = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Eventcard_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_main, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String name =personList.get(position).get("TAG_Name");
        holder.EventNameTextView.setText(personList.get(position).get("TAG_Name"));
        holder.EventDateTextView.setText(personList.get(position).get("TAG_Date"));
        holder.EventTimeTextView.setText(personList.get(position).get("TAG_Time"));
        holder.EventVenueTextView.setText(personList.get(position).get("TAG_Address"));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return personList.size();
    }
}
