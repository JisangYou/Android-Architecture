package com.example.myapplication;

import dagger.BindsInstance;
import dagger.Subcomponent;


/**
 * AppComponent의 Subcomponent로 아래와 같이 정의
 * 상위 Component를 상속받지는 않았지만, 의존성이 있게 구성을 했다.
 * 본래 취지는 AppComponent 인스턴스를 생성할때 아래 Component를 사용단계에서 선택적으로 사용할 수 있게 했고,
 * @ActivityScope 바인딩 메서드를 통해 액티비티 생명주기에 맞게 적용하려 했다.
 */

/**
 * 빌더 패턴
 * 객체 생성을 깔끔하게
 * 점층적 생성자 패턴(telescoping constructor pattern) 소개
 * 점층적 생성자 패턴의 대안으로 자바빈 패턴 소개
 * 자바빈 패턴의 대안으로 빌더 패턴 소개
 * 객체 생성을 유연하게
 * 빌더 인터페이스를 작성하여 다양한 빌더를 사용하는 방법 소개
 */

@Subcomponent(modules = MainActivityModule.class)
//@ActivityScope
public interface MainActivityComponent  {
    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
       Builder setModule(MainActivityModule module);

        @BindsInstance
        Builder setActivity(MainActivity activity);

        MainActivityComponent build();
    }
}
