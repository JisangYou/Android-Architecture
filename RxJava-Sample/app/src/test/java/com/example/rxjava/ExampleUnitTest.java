package com.example.rxjava;

import android.text.BoringLayout;

import org.junit.Test;
import org.reactivestreams.Publisher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void imperative_programming() {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);


        for (Integer item : items) {
            if (item % 2 == 0) {
                System.out.println(item);
            }
        }
        items.add(5);
        items.add(6);
        items.add(7);
        items.add(8);
    }

    @Test
    public void reactive_programming() {
        PublishSubject<Integer> items = PublishSubject.create();
        items.onNext(1);
        items.onNext(2);
        items.onNext(3);
        items.onNext(4);
        items.filter(item -> item % 2 == 0).subscribe(System.out::println);
        items.onNext(5);
        items.onNext(6);
        items.onNext(7);
        items.onNext(8);
    }

    /**
     * create() 연산자
     */
    @Test
    public void observable_create() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
//            emitter.onNext("World");
//            emitter.onComplete();
            emitter.onError(new Throwable()); // 에러를 던지면,
            emitter.onNext("World");
        });

//        source.subscribe(System.out::println);
        source.subscribe(System.out::println, throwable -> System.out.println("Error!!")); // 구독자는 에러를 적절하게 처리한다.
    }

    /**
     * just() 연산자
     */

    @Test
    public void observable_just() {
        // null 허용하지 않기에, 필요하면 Observable.empty() 연산자를 사용
        Observable<String> source = Observable.just("Hello", "World");
        source.subscribe(System.out::println);
    }


    /**
     * fromArray() 연산자
     * <p>
     * 아이템을 순차적으로 발행
     */
    @Test
    public void observable_fromArray() {
        String[] itemArray = new String[]{"A", "B", "C"};
        Observable source = Observable.fromArray(itemArray);
        source.subscribe(System.out::println);
    }

    /**
     * fromIterable() 연산자
     * arraylist, hashset 등 사용할 때
     */

    @Test
    public void observable_fromIterable() {
        ArrayList itemList = new ArrayList();
        itemList.add("A");
        itemList.add("B");
        itemList.add("C");
        Observable source = Observable.fromIterable(itemList);
        source.subscribe(System.out::println);
    }


    /**
     * future 인터페이스는
     * 비동기 작업의 결과를 구할 떄 사용
     * 추후, 스케쥴러로 대체 가능
     */

    @Test
    public void observable_fromFuture() {
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(5000);
            return "Hello World";
        });
        Observable source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
    }

    /**
     * publisher는 잠재적인 아이템 발행을 제공하는 생산자로 subscriber로부터 요청을 받아 아이템을 발행
     */

    @Test
    public void observable_fromPublisher() {
        Publisher<String> publisher = subscriber -> {
            subscriber.onNext("A");
            subscriber.onNext("B");
            subscriber.onNext("C");
            subscriber.onComplete();
        };
        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);
    }

    /**
     * Callable 인터페이스는 비동기적인 실행 결과를 반환한다는 점이 Runnnable과 다르다.
     */

    @Test
    public void observable_fromCallable() {
        Callable<String> callable = () -> "Hello World";
        Observable source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }


    /**
     * Single은 다르게 단 하나의 아이템만을 발행하는 특징이 있다.
     * HTTP 요청/응답
     */

    @Test
    public void observable_single() {
        Single.just("Hello World").subscribe(System.out::println);

        Single.create(emitter -> emitter.onSuccess("Hello"))
                .subscribe(System.out::println);

        Observable<Integer> src = Observable.just(1, 2, 3);
        Single<Boolean> singleSrc1 = src.all(i -> i > 0);
        Single<Integer> singleSrc2 = src.first(-1);
        Single<List<Integer>> singleSrc3 = src.toList();

        singleSrc1.subscribe(System.out::println);
        singleSrc2.subscribe(System.out::println);
        singleSrc3.subscribe(System.out::println);

        Single<String> singleSrc = Single.just("Hello World");
        Observable<String> observableSrc = singleSrc.toObservable();

        observableSrc.subscribe(System.out::println);

    }

    /**
     * Maybe는 아이템을 발행하거나 발행하지 않을 수도 있다.
     */

    @Test
    public void observable_maybe() {
        Maybe.create(emitter -> {
            emitter.onSuccess(100);
            emitter.onComplete();
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess1"))
                .doOnComplete(() -> System.out.println("doOnComplete1"))
                .subscribe(System.out::println);

        Maybe.create(emitter -> {
            emitter.onComplete();
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess2"))
                .doOnComplete(() -> System.out.println("doOnComplete2"))
                .subscribe(System.out::println);


    }

    @Test
    public void observable_maybe2() {
        Observable<Integer> src1 = Observable.just(1, 2, 3);
        Maybe<Integer> srcMaybe1 = src1.firstElement();
        srcMaybe1.subscribe(System.out::println);

        Observable<Integer> src2 = Observable.empty();
        Maybe<Integer> srcMaybe2 = src2.firstElement();
        srcMaybe2.subscribe(System.out::println, throwable -> {
        }, () -> System.out.println("onComplete!"));
    }

    /**
     * Completable
     * <p>
     * 정상 실행 됬는지에 대한 것만 관심을 갖는다.
     */


    @Test
    public void observable_completable() {

        Completable.create(emitter -> {
            emitter.onComplete();
        }).subscribe(() -> System.out.println("completed1"));

        Completable.fromRunnable(() -> {

        }).subscribe(() -> System.out.println("completed2"));
    }

    @Test
    public void cold_observable() {
        Observable src = Observable.interval(1, TimeUnit.SECONDS);
        src.subscribe(value -> System.out.println("#1: " + value));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        src.subscribe(value -> System.out.println("#2: " + value));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectable_observable() throws InterruptedException {
        ConnectableObservable src = Observable.interval(1, TimeUnit.SECONDS).publish();
        src.connect();
        src.subscribe(value -> System.out.println("#1: " + value));
        Thread.sleep(3000);
        src.subscribe(value -> System.out.println("#2: " + value));
        Thread.sleep(3000);
    }

    /**
     * 구독자가 2개 붙어야 발행
     *
     * @throws InterruptedException
     */
    @Test
    public void auto_connect() throws InterruptedException {
        Observable<Long> src = Observable.interval(100, TimeUnit.MILLISECONDS).publish().autoConnect(2);

        src.subscribe(i -> System.out.println("A: " + i));
        src.subscribe(i -> System.out.println("B: " + i));
        Thread.sleep(500);
    }

    /**
     *
     * 페기하는 기능     *
     */
    @Test
    public void disposable_test1() {
        Observable source = Observable.just("A", "B", "C");
        Disposable disposable = source.subscribe(o -> System.out.println(source));
    }


    @Test
    public void disposable_test2() {
        Observable source = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Disposable disposable = source.subscribe(System.out::println);
        new Thread(()->{
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            disposable.dispose();
        }).start();
    }

    @Test
    public void composite_disposable(){
        Observable source = Observable.interval(1000,TimeUnit.MILLISECONDS);
        Disposable d1 = source.subscribe(System.out::println);
        Disposable d2 = source.subscribe(System.out::println);
        Disposable d3 = source.subscribe(System.out::println);
        CompositeDisposable cd = new CompositeDisposable();
        cd.add(d1);
        cd.add(d2);
        cd.add(d3);

        cd.dispose();
    }


}