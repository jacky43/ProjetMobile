package ca.projetmobileui.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitApi {

    @POST("/searches")
    Call<Void> createPost(@Body User recherche);

    @Retry
    @GET("/api/User")
    Call<List<User>> getUsers();

    @POST("/api/User")
    Call<Void> createUser(@Body User user);

    @POST("/messages")
    Call<Void> createMessage(@Body User receiveMessage);

}
