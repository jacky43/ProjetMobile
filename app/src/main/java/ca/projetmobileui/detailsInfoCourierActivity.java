package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detailsInfoCourierActivity extends AppCompatActivity {

    private TextView txtFirstNameCourier;
    private TextView txtLastNameCourier;
    private TextView txtAdressCourier;
    private TextView txtPhoneCourier;
    private TextView txtDateHeureCourier;

    private Button btnUpdate;
    private Button btnBackListCourse;

    String firstName;
    String lastName;
    String adress;
    String phoneNumber;
    String dateCourse;
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
        btnBackListCourse = findViewById(R.id.btnBackListCourse);

        Intent intent = getIntent();

        firstName = intent.getStringExtra("firstName");
        txtFirstNameCourier.setText(firstName);
        lastName = intent.getStringExtra("lastName");
        txtLastNameCourier.setText(lastName);
        adress = intent.getStringExtra("adress");
        txtAdressCourier.setText(adress);
        phoneNumber = intent.getStringExtra("phoneNumber");
        txtPhoneCourier.setText(phoneNumber);
        dateCourse = intent.getStringExtra("dateCourse");
        txtDateHeureCourier.setText(dateCourse);

        btnBackListCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(detailsInfoCourierActivity.this, ListeDesCoursesActivity.class);
                startActivity(i);
            }
        });
    }
}