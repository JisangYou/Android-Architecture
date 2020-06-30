package com.example.myapplication.Module;

import dagger.Module;
import dagger.Provides;

/**
 * 상속
 */
@Module(includes = ModuleA.class)
public class ModuleB {
    @Provides
    B provideB() {
        return new B();
    }
}
