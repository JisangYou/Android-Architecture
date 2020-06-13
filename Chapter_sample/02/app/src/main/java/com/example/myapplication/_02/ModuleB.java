package com.example.myapplication._02;

import dagger.Module;
import dagger.Provides;

@Module(includes = ModuleA.class)
public class ModuleB {
    @Provides
    B provideB() {
        return new B();
    }

    class B {

    }
}
