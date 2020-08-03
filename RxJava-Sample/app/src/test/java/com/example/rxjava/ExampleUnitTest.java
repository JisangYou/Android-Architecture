package com.example.rxjava;


import org.junit.Test;


import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * Observable과 Observer를 모두 구현한 추상 타입으로 하나의 소스로부터 다중의 구독자에게 멀티 캐스팅이 가
     */
    @Test
    public void publishSubject() {
        Subject<String> src = PublishSubject.create();
        src.subscribe(item -> System.out.println("A: " + item),
                t -> t.printStackTrace(), () -> System.out.println("A: onComplete"));
        src.subscribe(item -> System.out.println("B : " + item),
                t -> t.printStackTrace(), () -> System.out.println("B: onComplete"));
        src.onNext("Hello");
        src.onNext("World");
        src.onNext("!!!");
        src.onComplete();
    }

    @Test
    public void publishSubject2() throws InterruptedException {
        Observable src1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable src2 = Observable.interval(500, TimeUnit.MILLISECONDS);
        PublishSubject subject = PublishSubject.create();
        src1.map(item -> "A: " + item).subscribe(subject);
        src2.map(item -> "B: " + item).subscribe(subject);
        subject.subscribe(System.out::println);
        Thread.sleep(5000);
    }
}