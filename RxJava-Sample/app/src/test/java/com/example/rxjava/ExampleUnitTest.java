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

    /**
     * 특정 인덱스에 해당하는 값
     */
    @Test
    public void elementAt() {
        Observable.just(1, 2, 3, 4).elementAt(2).subscribe(System.out::println);
    }

    /**
     * 조건식이 true 일떄만 아이템을 발
     */
    @Test
    public void filter() {
        Observable.just(2, 30, 22, 5, 60, 1)
                .filter(x -> x > 10)
                .subscribe(System.out::println);
    }

    /**
     * 일정 시간 간격으로 최근에 Observable이 배출한 아이템들을 방출하는 연산자이다.
     *
     * @throws InterruptedException
     */
    @Test
    public void sample() throws InterruptedException {
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .sample(300, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    /**
     * n개의 아이템을 무시하고 이후에 나오는 아이템을 발행하는 연산
     */

    @Test
    public void skip() {
        Observable.just(1, 2, 3, 4).skip(2).subscribe(System.out::println);
    }

    /**
     * skip과 반대로 n개의 아이템만 방출하는 연산
     */

    @Test
    public void take() {
        Observable.just(1, 2, 3, 4).take(2).subscribe(System.out::println);
    }

    /**
     * 모든 발행되는 아이템이 특정 조건을 만족할 때 true를 반환한다.
     */

    @Test
    public void all() {
        Observable.just(2, 1).all(integer -> integer > 0).subscribe(System.out::println);
    }

    /**
     * 여러 개의 Observable들을 동시에 구독하고, 그중 가장 먼저 아이템을 발행하는 Observable을 선택하고 싶을
     */
    @Test
    public void amb() {
        ArrayList<Observable<Integer>> list = new ArrayList<>();
        list.add(Observable.just(20, 40, 60).delay(100, TimeUnit.MILLISECONDS));
        list.add(Observable.just(1, 2, 3));
        list.add(Observable.just(0, 0, 0).delay(200, TimeUnit.MILLISECONDS));
        Observable.amb(list).subscribe(System.out::println);
    }

    /**
     * 여러 Observable 소스를 결합하여 하나의 Observable을 생성하고, 동작하는 연산자
     * 여러개의 http 요청에 의한 응답을 하나로 묶어서 처리할 때 사용
     */

    @Test
    public void combineLatest() throws InterruptedException {
        Observable<Integer> src1 = Observable.create(emitter -> {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    emitter.onNext(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
        Observable<String> src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    emitter.onNext("A");
                    Thread.sleep(700);
                    emitter.onNext("B");
                    Thread.sleep(100);
                    emitter.onNext("C");
                    Thread.sleep(700);
                    emitter.onNext("D");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        });
        Observable.combineLatest(src1, src2, (num, str) -> num + str).subscribe(System.out::println);
        Thread.sleep(5000);
    }


    /**
     * 여러 Observable을 하나의 Observable처럼 결합하여 사용
     */

    @Test
    public void merge() throws InterruptedException {
        Observable src1 = Observable.intervalRange(1, 5, 0, 100, TimeUnit.MILLISECONDS).map(value -> value * 20);
        Observable src2 = Observable.create(emitter ->
                new Thread(() -> {
                    try {
                        Thread.sleep(350);
                        emitter.onNext(1);
                        Thread.sleep(200);
                        emitter.onNext(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start());
        Observable.merge(src1, src2).subscribe(System.out::println);
        Thread.sleep(1000);
    }

    @Test
    public void error() {
        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).subscribe(System.out::println);
    }

    /**
     * subscribe 단에서 에러 핸들링
     */
    @Test
    public void throwable() {
        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).subscribe(System.out::println, throwable -> System.out.println("Error"));
    }

    /**
     * 오류가 발생하면 아이템 발행을 종료하고, onError()를 호출하는 대신에 오류처리를 위한 함수를 실행
     */

    @Test
    public void onErrorReturn() {
        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).onErrorReturn(throwable -> -1).subscribe(System.out::println);
    }

    /**
     * 오류 발생 시 기존 스트림을 종료시키고, 다른 Observable 소스로 스트림을 대체
     */

    @Test
    public void onErrorResumeNext() {
        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).onErrorResumeNext(throwable -> Observable.just(100, 200, 300)).subscribe(System.out::println);
    }


    /**
     * ObservableDL error를 발행할 때, Observable을 재구독하도록 한다.
     */

    @Test
    public void retry() {
//        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).retry().subscribe(System.out::println);
        Observable.just("1", "2", "a", "3").map(i -> Integer.parseInt(i)).retry(2).subscribe(System.out::println, throwable -> throwable.printStackTrace());
    }
}























