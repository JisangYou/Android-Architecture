package com.example.jetpack;


import android.os.Bundle;
import android.provider.SyncStateContract;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
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


    }
}