package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.repository.NewsDetailsRepository;
import com.jd.dailyplanet.viewmodel.NewsDetailsViewModel;
import com.jd.dailyplanet.viewmodel.ViewModelFactory;
import com.squareup.picasso.Picasso;

public class NewsDetailsFragment extends Fragment {

  private NewsDetailsViewModel newsDetailsViewModel;
  private ImageView thumbnail;
  private TextView body;

  public NewsDetailsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_news_details, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    thumbnail = view.findViewById(R.id.thumbnail);
    body = view.findViewById(R.id.newsDetailsScreen);

    newsDetailsViewModel = new ViewModelProvider(this,
      new ViewModelFactory(new NewsDetailsRepository()))
      .get(NewsDetailsViewModel.class);

    newsDetailsViewModel.fetchNewsDetails(getArguments().getString("newsId"));
    newsDetailsViewModel.getResponse().observe(getActivity(), detailsResponse -> {
      Log.e("jd", detailsResponse.toString());
      body.setText(detailsResponse.getResponse().getNews().getBodySummary().get(0).getBodyTextSummary());
      Picasso.get().load(detailsResponse.getResponse().getNews().getThumbnail()).into(thumbnail);
    });
  }
}