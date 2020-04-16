package com.jd.dailyplanet.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jd.dailyplanet.db.entity.News;
import com.jd.dailyplanet.repository.NewsDetailsRepository;
import com.jd.dailyplanet.rest.model.response.news_details.DetailsResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsDetailsViewModel extends ViewModel {

  private NewsDetailsRepository newsDetailsRepository;
  private CompositeDisposable disposable = new CompositeDisposable();

  private final MutableLiveData<DetailsResponse> response = new MutableLiveData<>();
  private final MutableLiveData<Boolean> error = new MutableLiveData<>();
  private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

  public NewsDetailsViewModel(NewsDetailsRepository newsDetailsRepository) {
    this.newsDetailsRepository = newsDetailsRepository;
  }

  public LiveData<DetailsResponse> getResponse() {
    return response;
  }

  public LiveData<Boolean> getError() {
    return error;
  }

  public LiveData<Boolean> isLoading() {
    return loading;
  }

  public void fetchNewsDetails(String newsId) {
    loading.setValue(true);
    disposable.add(newsDetailsRepository.getNewsDetails(newsId)
      .subscribeOn(Schedulers.io())
      .unsubscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread()).subscribe(this::onUserUpdate, this::onUserUpdateError, this::onComplete));
  }

  private void onComplete() {
    this.loading.setValue(false);
  }

  private void onUserUpdate(DetailsResponse detailsResponse) {
    this.response.setValue(detailsResponse);
    this.error.setValue(false);
  }

  public void readLater(News news) {
    newsDetailsRepository.readLater(news);
  }

  private void onUserUpdateError(Throwable throwable) {
    this.error.setValue(true);
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    if (disposable != null) {
      disposable.clear();
      disposable = null;
    }
  }
}
