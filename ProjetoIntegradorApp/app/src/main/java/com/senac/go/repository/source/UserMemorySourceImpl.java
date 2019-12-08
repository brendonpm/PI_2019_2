package com.senac.go.repository.source;

import com.senac.go.models.Usuario;

import java.util.List;

public class UserMemorySourceImpl implements UserMemorySource {

    private List<Usuario> userList;

    @Override
    public List<Usuario> getAll() {
        return userList;
    }

    @Override
    public Usuario crie(Usuario model) {
        userList.add(model);
        return null;
    }

    @Override
    public Usuario delete(Usuario model) {
        boolean removed = userList.remove(model);
        if (removed) {
            return model;
        } else {
            return null;
        }
    }

    @Override
    public Usuario recupere(Long identificador) {
        return null;
    }

    @Override
    public Usuario atualize(Usuario model) {
        return null;
    }
}
