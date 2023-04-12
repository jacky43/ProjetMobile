package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ca.projetmobileui.Models.Courier;
import ca.projetmobileui.Models.RetrofitApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListeDesDisponibiliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_disponibilite);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCourier);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetchRechercheItem(recyclerView);
    }

    private void fetchRechercheItem(RecyclerView recyclerView) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Courier>> call = retrofitApi.getCouriers();
        call.enqueue(new Callback<List<Courier>>() {
            @Override
            public void onResponse(Call<List<Courier>> call, Response<List<Courier>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Courier> couriers = response.body();
                recyclerView.setAdapter(new CustomRecyclerViewAdapter(couriers, ListeDesDisponibiliteActivity.this));
            }

            @Override
            public void onFailure(Call<List<Courier>> call, Throwable t) {
                Toast.makeText(ListeDesDisponibiliteActivity.this, "Erreur durant la récupération de la liste" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}