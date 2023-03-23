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
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnConnectClient = findViewById(R.id.btnConnectClient);
        btnConnectCourier = findViewById(R.id.btnConnectCourier);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}