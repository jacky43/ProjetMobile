package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MenuClientActivity extends AppCompatActivity {

    private Button btnChoisirDisponibilte;
    private Button btnCreateCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_client);
        liaison();
    }

    private void liaison() {
        btnChoisirDisponibilte = findViewById(R.id.btnChoisirDisponibilte);
        btnCreateCourse = findViewById(R.id.btnCreateCourse);

    }
}