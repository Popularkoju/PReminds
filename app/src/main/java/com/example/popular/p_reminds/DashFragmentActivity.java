package com.example.popular.p_reminds;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DashFragmentActivity extends Fragment {
ListView reminderDisplay;
ImageView addReminder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.view_remainder_list, null);
        return  v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reminderDisplay=view.findViewById(R.id.reminder_list);
        addReminder=view.findViewById(R.id.btnadd_remainder);

        List<Info> mylist = new ArrayList<>();
         mylist=MainActivity.appDatabase.dbObject().readInfo();
         reminderDisplay.setAdapter(new MyCustomListAdapter(getContext(),mylist));

         addReminder.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MainActivity.fragmentManager.beginTransaction().replace(R.id.frame, new AddReminder_fragment()).commit();
             }
         });





    }
}
