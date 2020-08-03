package com.example.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void schedulers() {
        /**
         * io 스케쥴러
         * 네트워크, 데이터베이스, 파일 시스템 환경 등의 블로킹 이슈가 발생하는 곳에서 비동기적인 작업을 위해 사용
         */
        Scheduler io = Schedulers.io();
        /**
         * newThread 스케쥴러
         * 매번 새로운 스케쥴러 생성
         */
        Scheduler newThread = Schedulers.newThread();
        /**
         * Computation 스케쥴러
         * 단순 반복작업, 콜백 그리고 다른 계산적인 작업에 사용
         */
        Scheduler computation = Schedulers.computation();
        /**
         * Trampoline 스케쥴러
         * 새로운 쓰레드 생성 X -> 현재 스레드에 무한한 크기의 큐를 생성하는 스케쥴러
         */
        Scheduler trampoline = Schedulers.trampoline();

        /**
         * mainThread 스케쥴러
         * 안드로이드 메인스레드에서 작동하는 스케쥴러
         */
        Scheduler mainThread = AndroidSchedulers.mainThread();
    }

    @Test
    public void schedulers1() {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.subscribe(s -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("#Obsv on" + threadName + ": " + s);
        });
    }

    @Test
    public void schedulers2() throws InterruptedException {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on" + threadName + ": " + s);
                });
        Thread.sleep(500);
    }

    @Test
    public void schedulers3() throws InterruptedException {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on" + threadName + ": " + s);
                });
        Thread.sleep(500);
    }

    @Test
    public void schedulers4() throws InterruptedException {

        Observable.interval(200, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on" + threadName + ": " + s);
                });
        Thread.sleep(1000);
        
    }


}