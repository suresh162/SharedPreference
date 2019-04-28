package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
    }

    private void SignUp() {
            SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");
            String password = sharedPreferences.getString("password", "");

            if (username.equals(etUsername.getText().toString()) ||
                password.equals(etPassword.getText().toString())) {
                Toast.makeText(this, "Successfull", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
        }


}
