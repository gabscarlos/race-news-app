package me.dio.racenews.data.remote;

import java.util.List;

import me.dio.racenews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;


public interface RaceNewsApi {
    @GET("news.json")
    Call<List<News>> getNews();
}
