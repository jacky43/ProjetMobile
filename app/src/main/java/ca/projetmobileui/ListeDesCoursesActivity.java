package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ca.projetmobileui.Models.Client;
import ca.projetmobileui.Models.Courier;
import ca.projetmobileui.Models.RetrofitApi;
import ca.projetmobileui.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListeDesCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_courses);

        RecyclerView recyclerView = findViewById(R.id.recycleViewClient);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        fetchRechercheItem(recyclerView);
    }

    private void fetchRechercheItem(RecyclerView recyclerView) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Client>> call = retrofitApi.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Client> clients = response.body();
                recyclerView.setAdapter(new CustomRecyclerViewAdapterClient(clients, ListeDesCoursesActivity.this));
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Toast.makeText(ListeDesCoursesActivity.this, "Erreur durant la récupération de la liste" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}