package com.example.jetpack;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

class UserObservable {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();

}
