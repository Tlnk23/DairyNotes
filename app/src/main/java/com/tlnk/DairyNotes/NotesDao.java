package com.tlnk.DairyNotes;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes ORDER BY dayOfWeek ASC")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();
}
