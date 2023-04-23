package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ca.projetmobileui.Models.RetrofitApi;
import ca.projetmobileui.Models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionActivity extends AppCompatActivity {

    private EditText edtEmailConnect;
    private EditText edtPasswordConnection;
    private Button btnConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        liaison();
    }

    private void liaison() {

        edtEmailConnect = findViewById(R.id.btnCourierMenu);
        edtPasswordConnection = findViewById(R.id.edtPasswordConnection);
        btnConnection = findViewById(R.id.btnConnection);

        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmailConnect.getText().toString();
                String password = edtPasswordConnection.getText().toString();
                getUser(email,password);
            }
        });
    }

    private void getUser(String email, String password) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<User>> call = retrofitApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<User> users = response.body();
                for(int i=0; i < users.size(); i++) {
                    if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)){
                        Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(ConnectionActivity.this, "email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
              
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(ConnectionActivity.this, "email ou mot de passe incorrect" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}