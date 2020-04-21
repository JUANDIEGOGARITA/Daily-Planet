package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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
      new ViewModelFactory(new NewsDetailsRepository(getContext())))
      .get(NewsDetailsViewModel.class);

    newsDetailsViewModel.fetchNewsDetails(getArguments().getString("newsId"));
    newsDetailsViewModel.getResponse().observe(getActivity(), detailsResponse -> {
      body.setText(detailsResponse.getResponse().getNews().getBodySummary());
      Picasso.get().load(detailsResponse.getResponse().getNews().getThumbnail()).into(thumbnail);
    });
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.details, menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == R.id.read_later) {
      if (item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.ic_book_default).getConstantState())) {
        item.setIcon(R.drawable.ic_book_selected);
      }
      else {
        item.setIcon(R.drawable.ic_book_default);
      }
    }
    return super.onOptionsItemSelected(item);
  }
}