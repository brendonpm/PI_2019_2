package com.senac.go.repository.task;

import android.os.AsyncTask;
import android.util.Log;

import com.senac.go.models.Usuario;
import com.senac.go.repository.IUserRepository;
import com.senac.go.repository.source.dao.UserDaoSource;

import java.util.ArrayList;
import java.util.List;

public class SaveUser extends AsyncTask<String, Integer, List<Usuario>> {
    private final UserDaoSource userDao;
    private IUserRepository.Callback<List<Usuario>> callback;
    private Usuario user;

    public SaveUser(UserDaoSource userDao, IUserRepository.Callback<List<Usuario>> callback, Usuario user) {
        this.userDao = userDao;
        this.callback = callback;
        this.user = user;
    }

    @Override
    protected List<Usuario> doInBackground(String... strings) {

        try {
            ArrayList<Usuario> userList = new ArrayList<>();
            Long userId = userDao.saveUser(user);
            if (userId > 0) {
                user.setCod(userId);
                userList.add(user);
                return userList;
            } else {
                Log.d("SaveAllTask", "Id invalido gerado");
                return null;
            }
        } catch (Exception e) {
            callback.onError(e);
        }
        return null;
    }
}
