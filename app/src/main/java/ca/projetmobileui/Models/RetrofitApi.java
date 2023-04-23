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
    @Retry
    @POST("/api/User")
    Call<Void> createUser(@Body User user);

    @POST("/api/Courier")
    Call<Void> createCourier(@Body Courier courier);
    @Retry
    @GET("/api/Courier")
    Call<List<Courier>> getCouriers();

    @POST("/api/Client")
    Call<Void> createClient(@Body Client client);
    @Retry
    @GET("/api/Client")
    Call<List<Client>> getClients();

}
