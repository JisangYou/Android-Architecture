package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        ActivityMainBinding binding1 = ActivityMainBinding.inflate(getLayoutInflater());
//        ActivityMainBinding binding2 = ActivityMainBinding.inflate(getLayoutInflater());
//        ActivityMainBinding binding3 = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, getParent(), attachToParent);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LinearLayout rootLayout = binding.root;
        /**
         * id로 View 참조하기.
         */
//        TextView textView = binding.tv;
//        textView.setText("Hello Jay");
        /**
         * 레이아웃에 변수 선언하기.
         */
//        binding.setMyText("Hello Jay~");
        /**
         * 포조 클래스 변수 선언
         */
        User user = new User("Jay", "ComeOn");
        binding.setUser(user);
    }
}