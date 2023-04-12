package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateAccount;
    private Button btnConnectClient;
    private Button btnConnectCourier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liaison();
    }
    private void liaison() {
        btnCreateAccount = findViewById(R.id.btnDisponibilite);
        btnConnectClient = findViewById(R.id.btnClientAccount);
        btnConnectCourier = findViewById(R.id.btnCourierAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        btnConnectCourier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConnectionActivity.class);
                startActivity(intent);
            }
        });
    }
}