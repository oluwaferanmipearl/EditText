package com.example.projectpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       TextView Name=(TextView)findViewById(R.id.A1);
        TextView Email = (TextView) findViewById(R.id.A2);
        TextView Password = (TextView) findViewById(R.id.A3);


        Intent intent = getIntent();

        String username = intent.getStringExtra("MESSAGE");
        Name.setText("Name: " + username);

        String userEmail = intent.getStringExtra("MESSAGE*");
        Email.setText("Email: "+ userEmail);

        String userPassword= intent.getStringExtra("MESSAGE_");
        Password.setText("Password: "+ userPassword);

    }
}
