package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsInfoClientActivity extends AppCompatActivity {

    private TextView txtFirstNameClient;
    private TextView txtLastNameClient;
    private TextView txtAdressClient;
    private TextView txtPhoneClient;
    private TextView txtDateHeureClient;
    private TextView txtPriceClient;
    private Button btnUpdate;
    private Button btnBackListDispo;

    String firstName;
    String lastName;
    String adress;
    String phoneNumber;
    String dateCourse;
    double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info_client);
        liaison();
    }

    private void liaison() {
        txtFirstNameClient = findViewById(R.id.txtFirstNameClient);
        txtLastNameClient = findViewById(R.id.txtLastNameClient);
        txtAdressClient = findViewById(R.id.txtAdressClient);
        txtPhoneClient = findViewById(R.id.txtPhoneClient);
        txtDateHeureClient = findViewById(R.id.txtDateHeureClient);
        txtPriceClient = findViewById(R.id.txtPriceClient);
        btnBackListDispo = findViewById(R.id.btnBackListDispo);

        Intent intent = getIntent();

        firstName = intent.getStringExtra("firstName");
        txtFirstNameClient.setText(firstName);
        lastName = intent.getStringExtra("lastName");
        txtLastNameClient.setText(lastName);
        adress = intent.getStringExtra("adress");
        txtAdressClient.setText(adress);
        phoneNumber = intent.getStringExtra("phoneNumber");
        txtPhoneClient.setText(phoneNumber);
        dateCourse = intent.getStringExtra("dateCourse");
        txtDateHeureClient.setText(dateCourse);
        price = intent.getDoubleExtra("price",0);
        txtPriceClient.setText(String.valueOf(price) + "$");

        btnBackListDispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailsInfoClientActivity.this, ListeDesDisponibiliteActivity.class);
                startActivity(i);
            }
        });
    }
}