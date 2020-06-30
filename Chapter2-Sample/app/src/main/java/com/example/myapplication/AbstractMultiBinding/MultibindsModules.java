package com.example.myapplication.AbstractMultiBinding;

import java.util.Collections;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.Multibinds;

@Module
public abstract class MultibindsModules {

    @Multibinds
    abstract Set<String> strings();

    @Provides
    @ElementsIntoSet
    static Set<String> emptyStrings(){
        return Collections.emptySet();
    }
}
