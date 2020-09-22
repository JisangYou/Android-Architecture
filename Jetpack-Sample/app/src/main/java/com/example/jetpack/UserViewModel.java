package com.example.jetpack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserViewModel extends ViewModel {

    private LiveData<PagedList<User>> users;
    private UserDao userDao;

    public UserViewModel(UserDao userDao) {
        this.userDao = userDao;
    }

    public void load() {
        users = new LivePagedListBuilder<>(userDao.getUsers(), 10).build();
    }

    public LiveData<PagedList<User>> getUsers() {
        return users;
    }
}
