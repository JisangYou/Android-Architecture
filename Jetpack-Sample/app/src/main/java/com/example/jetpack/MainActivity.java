package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jetpack.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        ActivityMainBinding binding1 = ActivityMainBinding.inflate(getLayoutInflater());
//        ActivityMainBinding binding2 = ActivityMainBinding.inflate(getLayoutInflater());
//        ActivityMainBinding binding3 = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, getParent(), attachToParent);

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /**
         * 바인딩 어댑터로 클릭이벤트 처리 가능
         */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main, new ClickBindingComponent(getLifecycle()));
        LinearLayout rootLayout = binding.root;
        binding.setClickListener(this);
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
//        User user = new User("Jay", "ComeOn");
//        binding.setUser(user);
        /**
         * 바인딩 표현식 중 Collections
         */
//        binding.setIndex(2);
//        binding.setKey("a");
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("2");
//        arrayList.add("3");
//        arrayList.add("4");
//        binding.setList(arrayList);
//        Map map = new HashMap();
//        map.put("test1","hello1");
//        map.put("test2","hello2");
//        map.put("test3","hello3");
//        binding.setMap(map);

        User user = new User("Jay", "ComeOn", "119");
//        binding.setUser(user);


    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "clicked",Toast.LENGTH_LONG).show();
    }
}