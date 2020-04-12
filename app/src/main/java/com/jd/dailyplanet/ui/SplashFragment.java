package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import com.jd.dailyplanet.R;

public class SplashFragment extends Fragment {

  public SplashFragment() {
    // Required empty public constructor
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_splash, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.splashScreen).setOnClickListener(v -> {
      NavDirections action =
        SplashFragmentDirections.actionSplashFragmentToNewsListFragment();

      NavHostFragment.findNavController(SplashFragment.this)
        .navigate(action, new NavOptions.Builder().setPopUpTo(R.id.splashFragment, true)
          .build());
    });
  }
}