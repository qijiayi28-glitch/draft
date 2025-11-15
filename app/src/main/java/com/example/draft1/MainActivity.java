package com.example.draft1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = findViewById(R.id.btnTest1);
        Button btn2 = findViewById(R.id.btnTest2);

        FirebaseFirestore db = FirebaseFirestore.getInstance().collection("testLogs").getFirestore();

        btn1.setOnClickListener(v -> {

            Map<String, Object> data = new HashMap<>();
            data.put("type", "Rescue");
            data.put("time", "now");
            db.collection("testLogs").add(data);

        });

        btn2.setOnClickListener(v -> {
            Map<String, Object> data = new HashMap<>();
            data.put("type", "PEF");
            data.put("value", 300);
            db.collection("testLogs").add(data);
        });

    }

}