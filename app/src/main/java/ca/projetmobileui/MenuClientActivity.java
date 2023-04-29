package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuClientActivity extends AppCompatActivity {

    private Button btnChoisirDisponibilte;
    private Button btnCreateCourse;
    private Button btnBackMAin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_client);
        liaison();
    }

    private void liaison() {
        btnChoisirDisponibilte = findViewById(R.id.btnChoisirDisponibilte);
        btnCreateCourse = findViewById(R.id.btnCreateCourse);
        btnBackMAin = findViewById(R.id.btnBackMAin);
        btnBackMAin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClientActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCreateCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClientActivity.this, AjouterCourseActivity.class);
                startActivity(intent);
            }
        });
        btnChoisirDisponibilte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClientActivity.this, ListeDesDisponibiliteActivity.class);
                startActivity(intent);
            }
        });
    }

}