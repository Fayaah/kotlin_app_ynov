package com.example.myapplication.network;

import com.example.myapplication.models.RandomUserResults;

import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Nicolas Churlet on 21/03/2018.
 */

public interface ErpInterventionApiService {

    // region GET ALL
    @GET("random?")
    Call<RandomUserResults> getMovies(@Query("key") String api_key, @Query("nb") Long nb );
    // endregion

    // region GET BY ID
    @GET("movie?")
    Call<RandomUserResults> getMovieByName(@Query("key") String api_key, @Query("id") Long id);

}
