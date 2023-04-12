package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class detailsInfoCourierActivity extends AppCompatActivity {

    private TextView txtFirstNameCourier;
    private TextView txtLastNameCourier;
    private TextView txtAdressCourier;
    private TextView txtPhoneCourier;
    private TextView txtDateHeureCourier;

    private Button btnUpdate;

    String firstName;
    String lastName;
    String address;
    String phoneNumber;
    String dateHeure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info_courier);
        liaison();
    }

    private void liaison() {
        txtFirstNameCourier = findViewById(R.id.txtFirstNameCourier);
        txtLastNameCourier = findViewById(R.id.txtLastNameCourier);
        txtAdressCourier = findViewById(R.id.txtAdressCourier);
        txtPhoneCourier = findViewById(R.id.txtPhoneCourier);
        txtDateHeureCourier = findViewById(R.id.txtDateHeureCourier);

        Intent intent = getIntent();



        firstName = intent.getStringExtra("firstName");
        txtFirstNameCourier.setText(firstName);
        lastName = intent.getStringExtra("lastName");
        txtLastNameCourier.setText(lastName);
        address = intent.getStringExtra("address");
        txtAdressCourier.setText(address);
        phoneNumber = intent.getStringExtra("phoneNumber");
        txtPhoneCourier.setText(phoneNumber);
        dateHeure = intent.getStringExtra("dateHeure");
        txtDateHeureCourier.setText(dateHeure);
    }
}