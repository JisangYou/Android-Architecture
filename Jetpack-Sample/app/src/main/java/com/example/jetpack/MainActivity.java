package com.example.jetpack;


import android.os.Bundle;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 작업 실행 방법 및 시기 구성
         */
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(UploadWorker.class).build();

        /**
         * 시스템에 작업 전달하기
         */
        WorkManager.getInstance(this).enqueue(request);

        /**
         * WorkRequest 정의하기
         */
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Constraints constraints = new Constraints.Builder().setRequiresDeviceIdle(true).setRequiresCharging(true).build();
            OneTimeWorkRequest compressWork = new OneTimeWorkRequest.Builder(CompressWorker.class).setConstraints(constraints).build();
        }

        /**
         * 초기 지연
         */

        OneTimeWorkRequest uploadWOrkRequest =
                new OneTimeWorkRequest.Builder(UploadWorker.class).setInitialDelay(10, TimeUnit.MINUTES).build();

        /**
         * 재시도 및 백 오프 정책
         */

        OneTimeWorkRequest uploadWorkRequest =
                new OneTimeWorkRequest.Builder(UploadWorker.class)
                        .setBackoffCriteria(
                                BackoffPolicy.LINEAR, OneTimeWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MICROSECONDS)
                        .build();

        /**
         * 작업의 입력/출력 정의
         */

        Data imageData = new Data.Builder().putString("key", "value").build();
        OneTimeWorkRequest uploadWorkRequest2 = new OneTimeWorkRequest.Builder(UploadWorker.class).setInputData(imageData).build();


        /**
         * 작업 상태
         * BLOCKED
         * CANCELLED
         * ENQUEUED
         * FAILED
         * RUNNING
         * SUCCEEDED
         */

        /**
         * 작업 관찰하기
         */

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.getId()).observe(getLifecycle(), Observer
//        {
//            workInfo -> if(workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED){
//            }
//        })

        /**
         * 작업 체이닝
         */
//        WorkManager.getInstance(this).beginWith(Arrays.asList(filter,filter,filter)).then(compress).then(upload).enqueue();

        /**
         * Input Merger
         */
//        OneTimeWorkRequest compress =
//                new OneTimeWorkRequest.Builder(CompressWorker.class).setInputMerger(ArrayCreatingInputMerger.class).setConstraints(constraints).build();

        /**
         * 작업 취소 및 중단
         */

//        WorkManager.getInstance(this).cancelWorkById(uploadWorkRequest.getId());


        /**
         * 반복 작업
         */

//        Constraints constraints = new Constraints.Builder().setRequiresCharging(true).build();
//        PeriodicWorkRequest saveRequest = new PeriodicWorkRequest.Builder(SaveImageFileWorker.class, 1, TimeUnit.HOURS).setConstraints(constraints).build();
//
//        WorkManager.getInstance(this).enqueue(saveRequest);
    }
}