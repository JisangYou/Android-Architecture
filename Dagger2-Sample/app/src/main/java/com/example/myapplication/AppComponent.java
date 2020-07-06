package com.example.myapplication;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


/**
 * app 컴포넌트 생성을 위한 코드
 * interface를 통해 추상화하며, Factory 패턴으로 인스턴스를 생성할 수 있도록 디자인 되어 있음.
 * 팩토리 메서드 패턴은 객체지향 디자인 패턴이다. Factory method는 부모 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴이며. 자식 클래스가 어떤 객체를 생성할지를 결정하도록 하는 패턴이기도 하다. 부모 클래스 코드에 구체 클래스 이름을 감추기 위한 방법으로도 사용
 * 다시 말해서, 객체 생성 하는 코드를 분리하여 클라이언트 코드와 결합도(의존성)를 낮추어 코드를 건드리는 횟수를 최소화 하기 위한 패턴
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    /**
     * MainActivityComponent를 Subcomponent 형태로 정의한다.
     * @return
     */
    MainActivityComponent.Builder mainActivityComponentBuilder();

    void inject(App app);

    @Component.Factory
    interface Factory {
        AppComponent create(
                @BindsInstance App app,
                AppModule appModule
        );
    }
}


