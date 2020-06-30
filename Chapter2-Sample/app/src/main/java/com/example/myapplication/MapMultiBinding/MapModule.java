package com.example.myapplication.MapMultiBinding;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class MapModule {

    @Provides
    @IntoMap
    @StringKey("foo")
    static Long provideFooValue() {
        return 100L;
    }

    @Provides
    @IntoMap
    @ClassKey(Foo4.class)
    static String provideFooStr() {
        return "Foo String";
    }
}
