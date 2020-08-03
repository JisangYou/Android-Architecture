package com.example.rxjava;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.lang.Thread.sleep;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * 발행과 소비가 균형적으로 일어나지 않음.
     * 구독자의 소비량과 관계 없이 아이템을 계속 발행하는 결과를 나타낸다. 이를
     * backpressure이라고 한다.
     *
     * @throws InterruptedException
     */

    @Test
    public void backPressure() throws InterruptedException {
        Observable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행: " + item);
                    return item;
                })
                .subscribe(item -> {
                    sleep(100);
                    System.out.println("아이템 소비: " + item);
                });
        Thread.sleep(30 * 1000);
    }

    @Test
    public void backPressure2() throws InterruptedException {
        Observable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행: " + item);
                    return item;
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(100);
                    System.out.println("아이템 소비: " + item);
                });
        Thread.sleep(30 * 1000);
    }


    /**
     * 아이템 발행량이 일정량 누적되면 더는 아이템을 발행하지 않는다.
     * 배압을 스스로 조절하는 점이 Flowable과 Observable의 차
     *
     * @throws InterruptedException
     */

    @Test
    public void flowable() throws InterruptedException {
        Flowable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행: " + item);
                    return item;
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(100);
                    System.out.println("아이템 소비: " + item);
                });
        Thread.sleep(30 * 1000);
    }

    /**
     * 시간을 기반으로 하는 Interval 연산자와 Flowable을 같이 사용한다면 문제가 발생할 수 있다.
     *
     * @throws InterruptedException
     */
    @Test
    public void flowable2() throws InterruptedException {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(item -> {
                    sleep(2000);
                    System.out.println("아이템 발행: " + item);
                    return item;
                }).subscribe(item -> {
            System.out.println("아이템 소비: " + item);
        }, throwable -> throwable.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    /**
     * 해당 연산자를 사용하면, 배압 구현이 되지 않은 Flowable에 대해 Backpressure Strategy.BUFFER를 적
     *
     * @throws InterruptedException
     */
    @Test
    public void onBackpressureBuffer() throws InterruptedException {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .map(item -> {
                    sleep(2000);
                    System.out.println("아이템 발행: " + item);
                    return item;
                })
                .subscribe(item -> {
                    System.out.println("아이템 소비: " + item);
                }, throwable -> throwable.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    /**
     * 스트림 버퍼가 가득 차면 최신의 아이템을 버퍼에 유지하려고 오래된 아이템을 버리는 연산
     *
     * @throws InterruptedException
     */
    @Test
    public void onBackpressureLatest() throws InterruptedException {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    System.out.println("아이템 소비: " + item);
                }, throwable -> throwable.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    /**
     * 버퍼가 가득 찬 상태에서 버퍼에 든 아이템을 소비하는 쪽이 바쁘다면 발행된 아이템을 버리는 연
     */

    @Test
    public void onBackpressureDrop() throws InterruptedException {
        Flowable.range(1, 300)
                .onBackpressureDrop()
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(10);
                    System.out.println("아이템 소비: " + item);
                }, throwable -> throwable.printStackTrace());
        Thread.sleep(30 * 1000);
    }


    /**
     *
     * BackpressureStrategy.MISSING
     * 기본적으로 배압 전략을 구현하지 않는다.
     *
     * BackpressureStrategy.ERROR
     * 스트림에서 소비자가 생산자를 따라가지 못하는 경우 예외를 발생
     * MissionBackpressure
     *
     * BackpressureStrategy.BUFFER
     * 구독자가 아이템을 소비할 때까지 발행한 아이템들을 버퍼에 넣어 둔다.
     * outOfMemoryError를 발생시킬 수 있다.
     *
     * BackpressureStrategy.DROP
     * 구독자가 아이템을 소비하느라 바빠서 생산자를 못 따라가는 경우 발행된 아이템을 모두 무시하고 버린다.
     *
     * BackpressureStrategy.LATEST
     * 구독자가 아이템을 받을 준비가 될 떄까지 가장 최신의 발행된 아이템들만 유지하고 이전 아이템은 버린다.
     *
     * @throws InterruptedException
     */
    @Test
    public void flowableCreate() throws InterruptedException {
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isCancelled()) {
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(System.out::println, throwable -> throwable.printStackTrace());
        sleep(100);
    }
}