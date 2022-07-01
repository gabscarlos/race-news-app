package me.dio.racenews.data;

import androidx.room.Room;

import me.dio.racenews.App;
import me.dio.racenews.data.local.RaceNewsDb;
import me.dio.racenews.data.remote.RaceNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RaceNewsRepository {

   //Constantes
   private static final String REMOTE_API_URL = "https://gabscarlos.github.io/race-news-api/";
   private static final String LOCAL_DB_NAME = "race-news";

   //Atributos: encapsulam o acesso a API (Retrofit) e banco de dados local (Room)
   private RaceNewsApi remoteApi;
   private RaceNewsDb localDb;

   public RaceNewsApi getRemoteApi() {
      return remoteApi;
   }
   public RaceNewsDb getLocalDb() {
      return localDb;
   }

   //Singleton: garante uma instancia unica dos atributos relacionados ao Retrofit e Room
   private RaceNewsRepository () {
      remoteApi = new Retrofit.Builder()
              .baseUrl(REMOTE_API_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(RaceNewsApi.class);

      localDb = Room.databaseBuilder(App.getInstance(), RaceNewsDb.class, LOCAL_DB_NAME).build();
   }

   public static RaceNewsRepository getInstance()  {
      return LazyHolder.INSTANCE;
   }

   private static class LazyHolder {
      private static final RaceNewsRepository INSTANCE = new RaceNewsRepository();
   }

}
