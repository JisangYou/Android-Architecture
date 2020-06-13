package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    String activityName;

    @Inject
    Integer randomNumber;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getComponent().mainFragmentComponentBuilder().setModule(new MainFragmentModule()).setFragment(this).build().inject(this);
        }

        Log.d("MainFragment", activityName);
        Log.d("MainFragment", "randomNumber = " + randomNumber);
    }
}
