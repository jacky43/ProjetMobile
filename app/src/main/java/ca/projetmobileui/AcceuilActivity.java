package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcceuilActivity extends AppCompatActivity {

    private Button btnAcceuilConnection;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        liaison();
    }

    private void liaison() {
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnAcceuilConnection = findViewById(R.id.btnAcceuilConnection);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        btnAcceuilConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilActivity.this, ConnectionActivity.class);
                startActivity(intent);
            }
        });
    }

}