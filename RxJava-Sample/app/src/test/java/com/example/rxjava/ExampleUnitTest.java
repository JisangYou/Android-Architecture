package com.example.rxjava;


import org.junit.Test;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import static java.lang.Thread.sleep;

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
        sleep(5000);
    }

    /**
     * 만약 서로 다른 스레드에서 Subject에 접근하여 아이템을 발행하는 상황에서는 subject가 안전을 보장하지 않는다.
     */
    @Test
    public void serializedSubject() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Subject<Object> subject = PublishSubject.create().toSerialized();
        subject.doOnNext(i -> counter.incrementAndGet())
                .doOnNext(i -> counter.decrementAndGet())
                .filter(i -> counter.get() != 0)
                .subscribe(System.out::println, throwable -> throwable.printStackTrace());
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    sleep(1);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                subject.onNext(i);
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        sleep(1000);
        System.out.println("종료");
    }

    /**
     * 새로운 Observer를 통해 구독 시 가장 마지막 아이템만을 발행
     * 가장 최근 상태값을 가져온다.
     */
    @Test
    public void behaviorSubject() {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    /**
     * 새로운 구독자가 구독을 요청하면 이전에 발행했던 아이템 모두를 구독자에게 전달한다.
     */

    @Test
    public void replaySubject() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    /**
     * AsyncSubject는 onComplete() 호출 직전에 발행된 아이템만을 구독자들에게 전달하는 특징이 있음.
     */
    @Test
    public void asyncSubject() {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.onComplete();
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    /**
     * 다른 subject처럼 아이템을 발행하고 구독한다.
     * unicastSubject에 구독하기 전까지는 발행하는 아이템을 버퍼에 저장하고, 구독이 시작할 때 버퍼에 있던
     * 아이템을 모두 발행하고 버퍼를 비워낸다. 그러므로 구독자를 여러개 둘 수 없다.
     * 첫 번째 구독자가 모든 아이템을 다 소비해 두번쨰 구독자부터는 아이템을 수신할 수 없다.
     */
    @Test
    public void unicastSubject() throws InterruptedException {
        Subject<Long> subject = UnicastSubject.create();
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(subject);
        sleep(3000);
        subject.subscribe(i -> System.out.println("A: " + i));
        sleep(2000);
    }
}