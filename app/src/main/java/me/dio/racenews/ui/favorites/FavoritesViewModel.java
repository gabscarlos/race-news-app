package me.dio.racenews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.dio.racenews.data.RaceNewsRepository;
import me.dio.racenews.domain.News;

public class FavoritesViewModel extends ViewModel {


    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return RaceNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> RaceNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }


}