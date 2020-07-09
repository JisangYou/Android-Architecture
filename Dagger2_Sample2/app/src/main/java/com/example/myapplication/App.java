package com.example.myapplication;

import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

/**
 * DispatchingAdnroidInjector를 제공하는 방법
 * : AndroidInjectionModule, HasAndroidInjector, DispatchingAndroidInjector
 *
 * dispatcher : 먼저 수행되야 할 작업을 선택해서 공급
 */
public class App extends Application implements HasAndroidInjector {
    /**
     * HasAndroidInjector, AndroidInjector  문서 확인
     * https://dagger.dev/api/latest/dagger/android/package-summary.html
     */

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    /**
     * DispatchingAndroidInjector<Activity> 멤버변수를 만들고 @Inject 를 달아주면 inject 시에 Application Module 로 설정한 Activity 을 바인딩을 해줍니다.
     *
     * 출처: https://faith-developer.tistory.com/149 [개발 이야기]
     */

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.factory().create(this).inject(this);
    }


    /**
     * HasAndroidInjector를 implements 받으면
     * AndroidInjector<Object> androidInjector(){
     *     return
     * }
     * @return
     */
    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
