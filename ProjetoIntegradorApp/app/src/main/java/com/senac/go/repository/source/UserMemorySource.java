package com.senac.go.repository.source;

import com.senac.go.models.Usuario;

import java.util.List;

public interface UserMemorySource extends CrudSource<Usuario, Long> {
    List<Usuario> getAll();
}
