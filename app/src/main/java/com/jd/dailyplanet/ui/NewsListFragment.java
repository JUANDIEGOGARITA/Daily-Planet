package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.jd.dailyplanet.R;

public class NewsListFragment extends Fragment {

  public NewsListFragment() {
    // Required empty public constructor
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_news_list, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.newsListScreen).setOnClickListener(v -> {
      goToNewsDetailsFragment(view);
    });
  }

  public void goToNewsDetailsFragment(View view) {
    NavDirections action =
      NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment();
    Navigation.findNavController(view).navigate(action);
  }
}