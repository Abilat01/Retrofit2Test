package com.abilat.retrofit2test;

import android.os.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface serverApi {

    @GET("activity")
    Call<pojo> messages();

}
