package com.example.jetpack;

import android.view.View;

import androidx.databinding.BindingAdapter;

public interface ClickBinding {
    @BindingAdapter("onClick")
    void setOnclickListener(View view, View.OnClickListener onClickListener);
}
