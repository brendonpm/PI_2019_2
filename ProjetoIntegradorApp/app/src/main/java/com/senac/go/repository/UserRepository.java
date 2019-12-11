package com.senac.go.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.source.dao.UserDaoSource;
import com.senac.go.repository.status.InternetStatus;
import com.senac.go.repository.task.LoadUser;
import com.senac.go.repository.task.SaveUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserRepository implements IUserRepository {

    private Api userApi;

    private final UserDaoSource daoSource; //-----
    public InternetStatus iStatus; //-----
    public Context ctx; //-----

    public UserRepository(Api userApi,UserDaoSource daoSource,Context ctx) {
        this.userApi = userApi;
        this.daoSource = daoSource;
        this.ctx = ctx;
    }

    @Override
    public List<Usuario> getUser(Callback<List<Usuario>> callback, String nome) {

        iStatus = new InternetStatus();

        if(iStatus.isNetworkAvailable(ctx)) {
            AsyncTask<String, Integer, List<Usuario>> asyncTask = new LoadUser(userApi, callback, nome);
            asyncTask.execute();

            try {
//                AsyncTask<String, Integer, List<Usuario>> asyncTaskSave = new SaveUser(daoSource,callback,asyncTask.get().get(0));
//                asyncTaskSave.execute();
                return asyncTask.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }else{

            return null;
        }
    }
}
