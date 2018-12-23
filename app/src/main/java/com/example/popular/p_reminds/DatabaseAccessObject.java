package com.example.popular.p_reminds;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao


public interface DatabaseAccessObject {
    @Insert
    public void addInfo(Info i);

    @Query("Select *from reminderinfo")
    public List<Info> readInfo();

    @Update
    public void updateInfo(Info i);

    @Delete
    public void deleteData(Info i);
}
