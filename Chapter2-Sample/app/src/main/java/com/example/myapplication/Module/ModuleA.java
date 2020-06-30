package com.example.myapplication.Module;

import dagger.Module;
import dagger.Provides;

/**
 * 모듈간 상속간에는 중복되는 타입이 존재하면 안된다.
 */
@Module
public class ModuleA {
    @Provides
    A provideA(){
        return new A();
    }
}
