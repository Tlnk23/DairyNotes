package com.tlnk.DairyNotes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */

@Database(entities = {Note.class}, version =  1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase database;
    private static final String DB_NAME = "notes2_db";
    private static final Object LOCK = new Object();

    public static NotesDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, NotesDatabase.class, DB_NAME)
                        .build();
            }
        }
        return database;
    }

    public abstract NotesDao notesDao();
}
