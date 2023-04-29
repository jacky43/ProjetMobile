package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.projetmobileui.Models.Client;
import ca.projetmobileui.Models.Courier;
import ca.projetmobileui.Models.RetrofitApi;
import ca.projetmobileui.Models.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AjouterCourseActivity extends AppCompatActivity {

    private EditText edtFirstNameCourse;
    private EditText edtLastNameCourse;
    private EditText edtAdressCourse;
    private EditText edtPhoneNumberCourse;
    private EditText edtDateCourse;
    private EditText edtPriceCourse;
    private Button btnCreateNewCourse;
    private Button btnBackMenuCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_course);
        liaison();
    }

    private void liaison() {
        edtFirstNameCourse = findViewById(R.id.edtFirstNameCourse);
        edtLastNameCourse = findViewById(R.id.edtLastNameCourse);
        edtAdressCourse = findViewById(R.id.edtAdressCourse);
        edtPhoneNumberCourse = findViewById(R.id.edtPhoneNumberCourse);
        edtDateCourse = findViewById(R.id.edtDateCourse);
        edtPriceCourse = findViewById(R.id.edtPriceCourse);
        btnCreateNewCourse = findViewById(R.id.btnCreateNewCourse);
        btnBackMenuCourse = findViewById(R.id.btnBackMenuCourse);

        btnCreateNewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = edtFirstNameCourse.getText().toString();
                String lastName = edtLastNameCourse.getText().toString();
                String adress = edtAdressCourse.getText().toString();
                String phoneNumber = edtPhoneNumberCourse.getText().toString();
                String dateCourse = edtDateCourse.getText().toString();
                double price = Double.parseDouble(edtPriceCourse.getText().toString());
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
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.firstName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (lastName.isEmpty()) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.lastName_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (adress.isEmpty()) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.adress_vide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (phoneNumber.isEmpty()) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.phone_vide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (dateCourse.isEmpty()) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.dateInfo_empty, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!firstNameIsValid) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.firstName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!lastNameIsValid) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.lastName_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!adressIsValid) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.adress_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!phoneIsValid) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.phone_nom_valide, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                } else if (!dateIsValid) {
                    Toast.makeText(AjouterCourseActivity.this,
                            R.string.dateInfo_not_valid, Toast.LENGTH_SHORT).show();
                    isSaveInfo = false;
                }else if (price < 0 ){
                    Toast.makeText(AjouterCourseActivity.this,
                            "Le montant doit etre supérieur a 0", Toast.LENGTH_SHORT).show();
                }
                else if (price == 0 ){
                    Toast.makeText(AjouterCourseActivity.this,
                            "Le montant doit etre supérieur a 0", Toast.LENGTH_SHORT).show();
                }
                if (isSaveInfo) {
                    saveCourse(firstName, lastName, adress, phoneNumber, dateCourse,price );
                }
            }
        });

        btnBackMenuCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterCourseActivity.this, MenuClientActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveCourse(String firstName, String lastName, String adress, String phoneNumber, String dateCourse, double price) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Client client = new Client(firstName, lastName, adress, phoneNumber, dateCourse, price);
        Call<Void> call = retrofitApi.createClient(client);
        call.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AjouterCourseActivity.this, "disponibilité added to API", Toast.LENGTH_SHORT).show();
                    edtFirstNameCourse.setText("");
                    edtLastNameCourse.setText("");
                    edtAdressCourse.setText("");
                    edtPhoneNumberCourse.setText("");
                    edtDateCourse.setText("");
                    edtPriceCourse.setText("");
                }else{
                    Toast.makeText(AjouterCourseActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AjouterCourseActivity.this, "Data fail to API" + t, Toast.LENGTH_SHORT).show();

            }
        }));
    }
}