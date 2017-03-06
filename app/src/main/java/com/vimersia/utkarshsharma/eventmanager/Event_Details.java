package com.vimersia.utkarshsharma.eventmanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Event_Details extends AppCompatActivity {
    String event_address,event_name,event_date,event_time,event_desc;
String streetAddress="18, Institutional Area, Sector 32, Gurugram,, Gurugram, Haryana ,122001";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__details);
        Bundle extras = getIntent().getExtras();
         event_name= extras.getString("T_NAME");
         event_date= extras.getString("T_DATE");
         event_time= extras.getString("T_TIME");
        event_address= extras.getString("T_Address");
        event_desc= extras.getString("T_Desc");

        TextView t_name = (TextView) findViewById(R.id.event_detail_name_inflate);
        t_name.setText(event_name);
        TextView t_date = (TextView) findViewById(R.id.event_detail_date_inflate);
        t_date.setText(event_date);
        TextView t_time = (TextView) findViewById(R.id.event_detail_time_inflate);
        t_time.setText(event_time);
        TextView t_address = (TextView) findViewById(R.id.event_detail_address);
        t_address.setText(event_address);
        TextView t_desc = (TextView) findViewById(R.id.event_detail_description);
        t_desc.setText(event_desc);

        final ImageButton button = (ImageButton) findViewById(R.id.map_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/" + event_address);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);            }
        });
    }

}
