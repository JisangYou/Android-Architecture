package com.example.rxjava;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * 구독하기 직전에 Observable을 생성하여 가장 최신의 상태 또는 아이템이 포함되도록 하는 곳이 목적이라면 defer 연산자를 사용할 수 있다.
     */

    @Test
    public void defer() {
        Observable<Long> justSrc = Observable.just(System.currentTimeMillis());
        Observable<Long> deferSrc = Observable.defer(() -> Observable.just(System.currentTimeMillis()));
        System.out.println("#1 now = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#2 now = " + System.currentTimeMillis());
        justSrc.subscribe(time -> System.out.println("#1 time = " + time));
        deferSrc.subscribe(time -> System.out.println("#2 time = " + time));
    }

    @Test
    public void emptyAndNever() {
        /**
         * empty 연산자는 아이템을 발행하지는 않지만, 정상적으로 스트림을 종료시킨다.
         */
        Observable.empty().doOnTerminate(() -> System.out.println("empty 종료")).subscribe(System.out::println);
        /**
         * never 연산자는 아이템을 발행하지 않고, 스트림을 종료시키지도 않는다. 그럼 어떤 경우에 사용하는 것인가?
         */
        Observable.never().doOnTerminate(() -> System.out.println("never 종료")).subscribe(System.out::println);
//        Observable.empty().doOnTerminate(() -> System.out.println("empty 종료")).subscribe(System.out::println);
    }


    /**
     * interval 연산자는 주어진 시간 간격으로 순서대로 정수를 발행하는  Observable
     */
    @Test
    public void interval() {

        Disposable d = Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);
        try {
            Thread.sleep(5000);
            // 실행 시간 늘리면, 더 많이 출력
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d.dispose();
    }


    /**
     * 특정 범위의 아이템을 발행하고, 발행이 끝나면 스트림을 종료시킨다
     */
    @Test
    public void range() {
        Observable.range(1, 3).subscribe(System.out::println);
    }

    @Test
    public void timer() throws InterruptedException {
        Observable src = Observable.timer(1, TimeUnit.SECONDS);
        System.out.println("구독!");
        // 구독하면 1초 뒤에 아이템이 발행된다.
        src.subscribe(event -> System.out.println("실행!"));
        Thread.sleep(2001);
        // 쓰레드 슬립에 따라 실행이 여부 및 시점이 결정된다.
    }


    /**
     * 발행되는 아이템을 변환하는 가장 기본적인 방법이자, 가장 많이 사용하는 연산자
     */
    @Test
    public void map() {
        Observable<Integer> intSrc = Observable.just(1, 2, 3);
        Observable<Integer> strSrc = intSrc.map(value -> value * 10);
        strSrc.subscribe(System.out::println);
    }

    /**
     * Observable을 또 다른 Observable로 변환시킨다.
     * 1:N 형태로 새로운 시퀀스가 발행된다.
     */
    @Test
    public void flatMap() {
        Observable<String> src = Observable.just("a", "b", "c");
        src.flatMap(str -> Observable.just(str + 1, str + 2)).subscribe(System.out::println);
    }

    @Test
    public void flatMap_sample() {
        Observable.range(2, 8)
                .flatMap(x -> Observable.range(1, 9)
                        .map(y -> String.format("%d*%d=%d", x, y, x * y)))
                .subscribe(System.out::println);
    }


    /**
     * buffer 연산자는 Observable이 발행하는 아이템을 묶어서 List로 발행한다.
     */

    @Test
    public void buffer() {
        Observable.range(0, 10)
                .buffer(3)
                .subscribe(integers -> {
                    System.out.println("버퍼 데이터 발행");
                    for (Integer integer : integers) {
                        System.out.println("#" + integer);
                    }
                });
    }

    /**
     * 누적하는 개념
     */
    @Test
    public void scan() {
        Observable.range(1, 5)
                .scan((x, y) -> {
                    System.out.print(String.format("%d+%d=", x, y));
                    return x + y;
                })
                .subscribe(System.out::println);
    }

    /**
     * 그룹을 나눠서 발행.
     * 발행은 비동기적으로 한다?
     */

    @Test
    public void groupBy() {
        Observable
                .just("a", "b", "c", "ab", "cb", "db")
                .groupBy(item -> {
                    if (item.contains("a")) {
                        return "hey";
                    } else if (item.contains("b")) {
                        return "there";
                    } else {
                        return "N";
                    }
                })
                .subscribe(group -> {
                    System.out.println(group.getKey() + " 그룹 발행 시작");
                    group.subscribe(shape -> {
                        System.out.println(group.getKey() + ":" + shape);
                    });
                });
    }


    /**
     * debounce 연산자는 특정 시간 동안 다른 아이템이 발행되지 않을 때만 아이템을 발행하도록 하는 연산자이다.
     * 반복적으로 빠르게 발행죈 아이템들을 필터링할 때 유용
     */

    @Test
    public void debounce() throws InterruptedException {
        Observable.create(emitter -> {
            emitter.onNext("1");
            Thread.sleep(100);
            emitter.onNext("2");
            emitter.onNext("3");
            emitter.onNext("4");
            Thread.sleep(100);
            emitter.onNext("5");
            emitter.onNext("6");
        })
                .debounce(10, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        Thread.sleep(300);
    }


    /**
     * 이미 발행한 아이템을 중복해 발행하지 않도록 필터링한다.
     */

    @Test
    public void distinct() {
        Observable.just(1, 2, 2, 1, 3)
                .distinct()
                .subscribe(System.out::println);
    }
}