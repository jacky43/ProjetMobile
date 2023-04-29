package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.projetmobileui.Models.Courier;
import ca.projetmobileui.Models.RetrofitApi;
import ca.projetmobileui.Models.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AjouterDisponibilteActivity extends AppCompatActivity {

    private EditText edtFirstNameCourier;
    private EditText edtLastNameCourier;
    private EditText edtAdressCourier;
    private EditText edtPhoneNumberCourier;
    private EditText edtDateCourier;
    private Button btnCreateDispo;
    private Button btnBackMenuDispo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_disponibilte);
        liaison();
    }

    private void liaison() {
        edtFirstNameCourier = findViewById(R.id.edtFirstNameCourier);
        edtLastNameCourier = findViewById(R.id.edtLastNameCourier);
        edtAdressCourier = findViewById(R.id.edtAdressCourier);
        edtPhoneNumberCourier = findViewById(R.id.edtPhoneNumberCourier);
        edtDateCourier = findViewById(R.id.edtDateCourier);
        btnCreateDispo = findViewById(R.id.btnCreateDispo);
        btnBackMenuDispo = findViewById(R.id.btnBackMenuDispo);

        btnCreateDispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = edtFirstNameCourier.getText().toString();
                String lastName = edtLastNameCourier.getText().toString();
                String adress = edtAdressCourier.getText().toString();
                String phoneNumber = edtPhoneNumberCourier.getText().toString();
                String dateCourse = edtDateCourier.getText().toString();
                boolean firstNameIsValid =
                        Utils.checkRegexFirstName(firstName);
                boolean lastNameIsValid =
                        Utils.checkRegexLastName(lastName);
                boolean adressIsValid =
                        Utils.checkRegexAdress(adress);
                boolean phoneIsValid =
                        Utils.checkRegexPhoneNumber(phoneNumber);
                boolean dateIsValid =
                        Utils.checkRegexDateHeure(dateCourse);
                boolean isSaveInfo = true;
                if (firstName.isEmpty()) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.firstName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (lastName.isEmpty()) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.lastName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (adress.isEmpty()) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.adress_vide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (phoneNumber.isEmpty()) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.phone_vide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (dateCourse.isEmpty()) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.dateInfo_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!firstNameIsValid) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.firstName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!lastNameIsValid) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.lastName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!adressIsValid) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.adress_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!phoneIsValid) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.phone_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!dateIsValid) {
                    Toast.makeText(AjouterDisponibilteActivity.this,
                            R.string.dateInfo_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                }
                if (isSaveInfo) {
                    saveDisponibilite(firstName, lastName, adress, phoneNumber, dateCourse );
                }
            }
        });

        btnBackMenuDispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterDisponibilteActivity.this, MenuCourierActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveDisponibilite(String firstName, String lastName, String adress, String phoneNumber, String dateCourse) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Courier courier = new Courier(firstName, lastName, adress, phoneNumber, dateCourse);
        Call<Void> call = retrofitApi.createCourier(courier);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AjouterDisponibilteActivity.this, "disponibilité added to API", Toast.LENGTH_SHORT).show();
                    edtFirstNameCourier.setText("");
                    edtLastNameCourier.setText("");
                    edtAdressCourier.setText("");
                    edtPhoneNumberCourier.setText("");
                    edtDateCourier.setText("");
                }else{
                    Toast.makeText(AjouterDisponibilteActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AjouterDisponibilteActivity.this, "Data fail to API" + t, Toast.LENGTH_SHORT).show();

            }
        }));

    }
}