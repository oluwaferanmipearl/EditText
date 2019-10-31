package com.example.projectpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.NameInput);
        editTextPassword = findViewById(R.id.PasswordInput);
        editTextEmail = findViewById(R.id.EmailInput);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String usernameInputt = editTextUsername.getText().toString().trim();
                String passwordInputt = editTextPassword.getText().toString().trim();
                String EmailInputt = editTextEmail.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, Main2.class);

                intent.putExtra("MESSAGE",usernameInputt);
                intent.putExtra("MESSAGE_",passwordInputt);
                intent.putExtra("MESSAGE*",EmailInputt);

                MainActivity.this.startActivity(intent);



            }
        });
        editTextUsername.addTextChangedListener(loginTextWatcher);
        editTextPassword.addTextChangedListener(loginTextWatcher);
        editTextEmail.addTextChangedListener(loginTextWatcher);
        editTextEmail.addTextChangedListener(Textwatcher1);
    }



        private TextWatcher loginTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameInput = editTextUsername.getText().toString().trim();
                String passwordInput = editTextPassword.getText().toString().trim();
                String EmailInput = editTextEmail.getText().toString().trim();


                button.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() && !EmailInput.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        };
      private TextWatcher Textwatcher1 = new TextWatcher() {

          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              String EmailInput = editTextEmail.getText().toString().trim();
              String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
              button.setEnabled(EmailInput.matches(emailPattern));
          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
      };





}



