package com.example.prova190126.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.prova190126.data.Personagem;
import com.example.prova190126.data.PersonagemDao;

@Database(entities = {Personagem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract PersonagemDao personagemDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "banco_disney")
                    .build();
        }
        return INSTANCE;
    }
}


