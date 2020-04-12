package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.jd.dailyplanet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {

  public NewsListFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_news_list, container, false);
    View textView = view.findViewById(R.id.newsListScreen);
    textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        NavDirections action =
          NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment();
        NavHostFragment.findNavController(NewsListFragment.this).navigate(action);
      }
    });
    return view;
  }
}