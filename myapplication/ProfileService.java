package com.example.hamin.myapplication;

import android.telecom.Call;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfileService {

    @GET("forif/default")
    Call<FriendDTO> getProfileList();
}
