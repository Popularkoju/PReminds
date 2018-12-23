package com.example.popular.p_reminds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyCustomListAdapter extends BaseAdapter{
    Context c;
    List<Info> myremainder_data = new ArrayList<>();


    public MyCustomListAdapter(Context context, List<Info> mylist) {
        c =context;
        myremainder_data=mylist;
    }

    @Override
    public int getCount() {
        return myremainder_data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(c).inflate(R.layout.view_reminder_list_layout,null);
        TextView title =convertView.findViewById(R.id.reminder_title);
        TextView date =convertView.findViewById(R.id.reminder_date);
        TextView time=convertView.findViewById(R.id.reminder_time);


        title.setText(myremainder_data.get(position).getReminders());
        date.setText(myremainder_data.get(position).getDate().toString());
        time.setText(myremainder_data.get(position).getTime().toString());


        return convertView;
    }
}
