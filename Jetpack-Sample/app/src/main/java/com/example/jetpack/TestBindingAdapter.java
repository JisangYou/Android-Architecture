package com.example.jetpack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

public class TestBindingAdapter {
    @BindingAdapter({"error"})
    public static void loadImage(ImageView view, Drawable error) {
        Glide.with(view).load(error).error(error).into(view);
    }

}
