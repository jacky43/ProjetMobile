package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCourierActivity extends AppCompatActivity {

    private Button btnChoisirCourse;
    private Button btnDisponiblité;
    private Button btnBackMAin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_courier);
        liaison();
    }

    private void liaison() {
        btnChoisirCourse = findViewById(R.id.btnChoisirCourse);
        btnDisponiblité = findViewById(R.id.btnCreateDisponibilite);
        btnBackMAin = findViewById(R.id.btnBackMAin);

        btnDisponiblité.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCourierActivity.this, AjouterDisponibilteActivity.class);
                startActivity(intent);
            }
        });

        btnChoisirCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCourierActivity.this, ListeDesCoursesActivity.class);
                startActivity(intent);
            }
        });
        btnBackMAin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCourierActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}