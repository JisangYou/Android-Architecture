package com.example.jetpack;

import androidx.databinding.DataBindingComponent;
import androidx.lifecycle.Lifecycle;

public class ClickBindingComponent implements DataBindingComponent {

    private final ClickBindingImpl clickBinding;

    public ClickBindingComponent(Lifecycle lifecycle) {
        this.clickBinding = new ClickBindingImpl(lifecycle);
    }

    @Override
    public ClickBinding getClickBinding() {
        return clickBinding;
    }
}
