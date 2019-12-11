package com.senac.go.repository.source.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.senac.go.models.Usuario;

import java.util.List;

@Dao
public interface UserDaoSource {
    @Insert
    Long saveUser(Usuario user);

    @Query("select * from usuario")
    List<Usuario> getAll();
}
