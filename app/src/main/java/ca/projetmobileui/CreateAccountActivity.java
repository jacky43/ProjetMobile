package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.projetmobileui.Models.RetrofitApi;
import ca.projetmobileui.Models.User;
import ca.projetmobileui.Models.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtDateBorn;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private Button btnCreateUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        liaison();

    }

    private void liaison() {
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtDateBorn = findViewById(R.id.edtDateBorn);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnCreateUser = findViewById(R.id.btnCreateUser);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String email = edtEmail.getText().toString();
                String dateBorn = edtDateBorn.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtPassword.getText().toString();
                boolean firstNameIsValid =
                        Utils.checkRegexFirstName(firstName);
                boolean lastNameIsValid =
                        Utils.checkRegexLastName(lastName);
                boolean emailIsValid =
                        Utils.checkRegexEmail(email);
               boolean dateIsValid =
                       Utils.checkRegexDate(dateBorn);
                boolean passwordIsValid =
                        Utils.checkRegexPassword(password);
                boolean isSaveInfo = true;
                if (firstName.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.firstName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (lastName.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.lastName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (email.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.ville_vide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (dateBorn.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.dateBorn_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (password.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.password_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!firstNameIsValid) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.firstName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!lastNameIsValid) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.lastName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!emailIsValid) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.email_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!dateIsValid) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.dateBorn_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!passwordIsValid) {
                    Toast.makeText(CreateAccountActivity.this,
                            R.string.password_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                }if (!password.equals(confirmPassword)) {
                   Toast.makeText(CreateAccountActivity.this,
                           R.string.password_not_equal, Toast.LENGTH_SHORT).show();
                   isSaveInfo = false;
                }
                if (isSaveInfo) {
                    saveUser(firstName, lastName, dateBorn,email, password);
                }
            }
        });
    }


    private void saveUser(String firstName, String lastName, String dateBorn, String email, String password ) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        User user = new User(firstName, lastName, dateBorn, email, password);
        System.out.println(user.getDateBorn() + "-" + user.getEmail());
        Call<Void> call = retrofitApi.createUser(user);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(CreateAccountActivity.this, "User added to API", Toast.LENGTH_SHORT).show();
                System.out.println(response.raw());
                edtFirstName.setText("");
                edtLastName.setText("");
                edtEmail.setText("");
                edtDateBorn.setText("");
                edtPassword.setText("");
                edtConfirmPassword.setText("");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CreateAccountActivity.this, "Data fail to API" + t, Toast.LENGTH_SHORT).show();
                Log.w("Data failed",t);
                Log.getStackTraceString(t);
                System.out.println(t.getMessage());
            }
        }));

    }

}