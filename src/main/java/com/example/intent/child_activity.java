package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class child_activity extends AppCompatActivity {
    EditText edtkq;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtkq = findViewById(R.id.txtketqua);
        btnback = findViewById(R.id.btnBack);
        Intent yourIntent = getIntent();
        Bundle yourBundle = yourIntent.getBundleExtra("myBackage");
        int a = yourBundle.getInt("So a");
        int b = yourBundle.getInt("So b");
        String kq = "";
        if (a == 0 || b == 0){
            kq = "Vô số nghiệm";
        }else if(a == 0 && b!=0){
            kq= "Vô nghiệm";
        }else{
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format((-b)*1.0/a);
        }
        edtkq.setText(kq);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}