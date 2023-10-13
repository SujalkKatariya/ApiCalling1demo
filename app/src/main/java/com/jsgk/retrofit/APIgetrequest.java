package com.jsgk.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIgetrequest {
    @GET("api/users")
    Call<usermodal> getUsers();
}
