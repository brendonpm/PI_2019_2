package com.senac.go.repository.source.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.senac.go.models.Usuario;

@Database(entities = {Usuario.class}, version = 1,exportSchema = false)
public abstract class AbstractDatabase extends RoomDatabase {
    public abstract UserDaoSource createDaoSource();
}
