package com.example.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * AndroidInjectionModule.class 을 Modules 로 설정하면서 dagger.android 에서 제공하는 Class을 사용할 수 있습니다.
 *
 * 출처: https://faith-developer.tistory.com/149 [개발 이야기]
 *
 *
 * 전체적으로 싱글톤으로 세팅하여 관리하는데 이는 application level에서 관리
 *
 * Dagger를 사용하여 Android 애플리케이션을 작성하는 가장 큰 어려움 중 하나는 많은 Android 프레임 워크 클래스가 Activity 및 Fragment 와 같은 OS 자체로 인스턴스화되지만
 * Dagger는 삽입 된 모든 객체를 생성 할 수 있다면 가장 잘 작동
 *
 *
*/
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class}) //abstract class 들
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    interface Factory extends AndroidInjector.Factory<App> {

    }
}
