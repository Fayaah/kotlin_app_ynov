package com.example.myapplication.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.myapplication.models.RandomUserResults;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static android.content.Context.MODE_PRIVATE;

public class ApiHelpers {

    public static final String ENDPOINT = "https://api.betaseries.com/movies/";
    public static final String API_KEY = "c00a17e632b7";

    private ErpInterventionApiService apiservice;

    final private Context _context;

    SharedPreferences preferences;
    public ApiHelpers(Context context) {
        this._context = context;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        // region OkHttpClient
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        final Request request = chain.request();

                        preferences = _context.getSharedPreferences("login", MODE_PRIVATE);
                        String token = preferences.getString("token", "");

                        final Request newRequest;
                        // cas de l'authentification
                        if (request.url().encodedPathSegments().get(0).equals("api") &&
                                request.url().encodedPathSegments().get(1).equals("Auth") &&
                                request.url().encodedPathSegments().get(2).equals("Login")) {
                            newRequest = request.newBuilder()
                                    .build();
                        } else if (token == null) {
                            return null;
                        } else {
                            newRequest = request.newBuilder()
                                    //ajoute "baerer: token" en header de chaque requête
                                    .addHeader("Authorization", "Bearer " + token)
                                    .build();
                        }
                        System.out.println("request = " + request);

                        return chain.proceed(newRequest);
                    }
                })
                .build();
        // endregion OkHttpClient

        // region API service
        apiservice = new Retrofit
                .Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
                .create(ErpInterventionApiService.class);
        // endregion API service
    }

    // region Async methods
    // region Getters

    // region Lists
    public void getForecastAsync(long nb_movies, ApiRequestCallback<RandomUserResults> callback) {
        (new ApiRequest<RandomUserResults>()).requestAsync(apiservice.getMovies(API_KEY, nb_movies), callback);
    }

    // endregion Lists

    // region By id
    // endregion By id

    // region By Name
    public void getFilmByNameAsync(Long movie_id, ApiRequestCallback<RandomUserResults> callback) {
        (new ApiRequest<RandomUserResults>()).requestAsync(apiservice.getMovieByName(API_KEY, movie_id), callback);
    }
    // endregion By Name
    // endregion Getters
    // endregion Async methods
}

