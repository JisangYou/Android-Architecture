package com.example.myapplication._01;

import dagger.Module;
import dagger.Provides;

@Module
//public abstract class MyModule {
// 추상클래스일 때는 static 메서드 이다.
public class MyModule {
    @Provides
    String provideHelloWorld() {
        return "Hello World";
    }

//    @Provides
//    String provideName() {
//        return "Charles";
//    }

//    @Provides
//    static String provideName() {
//        return "Charles";
//    }


    @Provides
    int provideAge() {
        return 100;
    }

//    @Provides
//    Person providePerson(String name, int age) {
//        return new Person(name, age);
//    }
}
