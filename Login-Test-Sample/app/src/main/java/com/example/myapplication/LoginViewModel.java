package com.example.myapplication;

import javax.inject.Inject;


@ActivityScope
public class LoginViewModel {
    private final UserRepository userRepository;

    // @Inject tells Dagger how to create instances of LoginViewModel
    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
