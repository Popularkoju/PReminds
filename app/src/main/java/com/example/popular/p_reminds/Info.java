package com.example.popular.p_reminds;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "reminderinfo")
public class Info {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "reminders")
    String reminders;

    @ColumnInfo(name = "Date")
    public String date;

    @ColumnInfo(name = "Time")
    public String time;

    public String getReminders() {
        return reminders;
    }

    public void setReminders(String reminders) {
        this.reminders = reminders;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
