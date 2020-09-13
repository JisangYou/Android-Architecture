package com.example.jetpack;

import java.math.BigDecimal;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;

public class StockLiveData extends LiveData<BigDecimal> {
    private static StockLiveData sInstance;
    private StockManager stockManager;

    private SimplePriceListener listener = new SimplePriceListener() {
        @Override
        public void onPriceChanged(BigDecimal price) {
            setValue(price);
        }
    };

    @MainThread
    public static StockLiveData get(String symbol) {
        if (sInstance == null) {
            sInstance = new StockLiveData(symbol);
        }
        return sInstance;
    }

    public StockLiveData(String symbol) {
        stockManager = new StockManager(symbol);
    }

    @Override
    protected void onActive() { // LiveData에 활성화된 관찰자가 있는 경우 호출된다.
        stockManager.requestPriceUpdates(listener);
    }

    @Override
    protected void onInactive() { // LiveData에 활성화된 관찰자가 없는 경우 호출된다.
        stockManager.removeUpdates(listener);
    }
}
