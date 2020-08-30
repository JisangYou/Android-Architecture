package com.example.jetpack;

import android.view.View;

public class Presenter {
    /**
     * 파라미터 한개
     *
     * @param task
     */
    public void onSaveClick(Task task) {
    }

    public void onSaveClick(View view, Task task) {

    }

    /**
     * 파라미터 두개 이상
     */

    public void onCompleteChanged(Task task, boolean completed) {

    }
}
