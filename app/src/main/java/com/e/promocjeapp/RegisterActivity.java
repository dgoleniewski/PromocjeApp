package com.e.promocjeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordRetypeEditText;
    private Button signInButton;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        intent = new Intent();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordRetypeEditText = findViewById(R.id.passwordRetypeEditText);
        signInButton = findViewById(R.id.signInButton);

        emailEditText.setText(intent.getStringExtra("email"));
        passwordEditText.setText(intent.getStringExtra("password"));

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailIsValid() && passwordsAreValid()){
                    String email = emailEditText.getText().toString();
                    String password = passwordEditText.getText().toString();
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Zarejestrowano poprawnie", Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                intent = new Intent(RegisterActivity.this, ListDiscountsActivity.class);
                                finish();
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, "Nie udało się zarejestrować", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private boolean emailIsValid(){
        String email = emailEditText.getText().toString();
        return email.contains("@") && email.length() > 7;
    }

    private boolean passwordsAreValid(){
        String password = passwordEditText.getText().toString();
        String passwordRetyped = passwordRetypeEditText.getText().toString();
        return password.equals(passwordRetyped);
    }
}
