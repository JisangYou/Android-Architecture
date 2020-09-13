package com.example.jetpack;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigDecimal;

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blank_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LiveData<BigDecimal> myPriceListener = new LiveData<BigDecimal>() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super BigDecimal> observer) {
                super.observe(owner, observer);
            }
        };
        String symbol = "symbol";
        StockLiveData.get(symbol).observe(getViewLifecycleOwner(), price -> {
        });


        /**
         * MediatorLiveData
         */

        LiveData liveData1 = new LiveData() {
            @Override
            protected void setValue(Object value) {
                super.setValue(value);
            }
        };
        LiveData liveData2 = new LiveData() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
                super.observe(owner, observer);
            }
        };

        MediatorLiveData liveDataMerger = new MediatorLiveData<>();
        liveDataMerger.addSource(liveData1, v -> liveDataMerger.setValue(v));
        liveDataMerger.addSource(liveData2, v -> liveDataMerger.setValue(v));
        liveDataMerger.addSource(liveData1, new Observer() {
            private int count = 1;

            @Override
            public void onChanged(Object o) {
                count++;
                liveDataMerger.setValue((int) o);
                if (count > 10) {
                    liveDataMerger.removeSource(liveData1);
                }
            }
        });
    }

    /**
     * LiveData 변형하기
     */

    /**
     * Transformations.map
     */

    LiveData<String> userLiveData = new LiveData<String>() {
        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
            super.observe(owner, observer);
        }
    };

//    LiveData userFullNameLiveData =
//            Transformations.map(userLiveData, user -> user.firstName + user.lastName);

}