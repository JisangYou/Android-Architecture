package com.example.jetpack;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


/**
 * 백 그라운드 작업 만들기
 */

public class UploadWorker extends Worker {
    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

//        uploadImages();
        String imageUriInput = getInputData().getString("key");
        Response response = uploadFile(imageUriInput);
        Data outputData = new Data.Builder().putString("key", "value").build();

        // 작업이 끝나면 알림을 준다.
        return Result.success(outputData);
//        return Result.success();
    }

    private void uploadImages() {
        /**
         * 이미지 업로드 코드
         */


    }

    private Response uploadFile(String imageUriInput) {
    }


}
