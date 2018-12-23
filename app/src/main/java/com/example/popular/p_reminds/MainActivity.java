package com.example.popular.p_reminds;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static android.support.v4.app.FragmentManager fragmentManager;

    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = Room.databaseBuilder(MainActivity.this, AppDatabase.class, "infodb").
         allowMainThreadQueries().build();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame, new DashFragmentActivity()).commit();
    }
}
