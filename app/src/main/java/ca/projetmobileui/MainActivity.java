package ca.projetmobileui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnClientMenu;
    private Button btnCourierMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liaison();
    }
    private void liaison() {
        btnClientMenu = findViewById(R.id.btnClientMenu);
        btnCourierMenu = findViewById(R.id.btnCourierMenu);

        btnClientMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuClientActivity.class);
                startActivity(intent);
            }
        });

        btnCourierMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuCourierActivity.class);
                startActivity(intent);
            }
        });
    }
}