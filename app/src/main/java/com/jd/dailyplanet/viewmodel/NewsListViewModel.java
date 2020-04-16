package com.jd.dailyplanet.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jd.dailyplanet.repository.NewsListRepository;
import com.jd.dailyplanet.rest.model.request.Section;
import com.jd.dailyplanet.rest.model.response.news_list.ListResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsListViewModel extends ViewModel {

  private final NewsListRepository newsListRepository;

  private CompositeDisposable disposable = new CompositeDisposable();

  private final MutableLiveData<ListResponse> response = new MutableLiveData<>();
  private final MutableLiveData<Boolean> error = new MutableLiveData<>();
  private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

  public NewsListViewModel(NewsListRepository newsListRepository) {
    this.newsListRepository = newsListRepository;
  }

  public LiveData<ListResponse> getResponse() {
    return response;
  }

  public LiveData<Boolean> getError() {
    return error;
  }

  public LiveData<Boolean> isLoading() {
    return loading;
  }

  public void search(String query) {
    loading.setValue(true);
    disposable.add(newsListRepository.search(query)
      .subscribeOn(Schedulers.io())
      .unsubscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread()).subscribe(this::onUserUpdate, this::onUserUpdateError, this::onComplete));
  }

  public void fetchReadLaterNewsList() {
    newsListRepository.getReadLaterNews();
  }

  public void fetchNewsList() {
    loading.setValue(true);
    disposable.add(newsListRepository.getNewsList()
      .subscribeOn(Schedulers.io())
      .unsubscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread()).subscribe(this::onUserUpdate, this::onUserUpdateError, this::onComplete));
  }

  public void fetchNewsListBy(Section sectionId) {
    loading.setValue(true);
    disposable.add(newsListRepository.getNewsListBy(sectionId)
      .subscribeOn(Schedulers.io())
      .unsubscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread()).subscribe(this::onUserUpdate, this::onUserUpdateError, this::onComplete));
  }

  private void onComplete() {
    this.loading.setValue(false);
  }

  private void onUserUpdate(ListResponse listResponse) {
    this.response.setValue(listResponse);
    this.error.setValue(false);
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
