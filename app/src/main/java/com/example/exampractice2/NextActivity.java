package com.example.exampractice2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent i = getIntent();
        String receivedMessage = i.getStringExtra("message");  // Retrieve "Hello "
        String userInput = i.getStringExtra("a");              // Retrieve user input from EditText

        // Find the TextView and display the combined message
        TextView textView = findViewById(R.id.textView);
        textView.setText(receivedMessage + userInput);  // Display "Hello " + user input
    }
}

// FirstActivity.java
//Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//intent.putExtra("KEY_STRING", "Hello World");
//intent.putExtra("KEY_INT", 100);
//intent.putExtra("KEY_BOOL", true);
//startActivity(intent);

// SecondActivity.java
//Intent intent = getIntent();
//String receivedString = intent.getStringExtra("KEY_STRING");
//int receivedInt = intent.getIntExtra("KEY_INT", 0);
//boolean receivedBool = intent.getBooleanExtra("KEY_BOOL", false);