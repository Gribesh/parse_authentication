package com.example.parseauthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends AppCompatActivity {


    public void login(View view) {
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        if (TextUtils.isEmpty(username.getText())) {
            username.setError("Username is required");
        }else if (TextUtils.isEmpty(password.getText())){
            password.setError("Password is required");
        }else{
            final ProgressDialog loading = new ProgressDialog(this);
            loading.setMessage("Loading");
            loading.show();
            ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null) {
                        loading.dismiss();
                        Log.i("Info", "User logged in");
                        redirectIfLoggedIn();
                    } else {
                        String message = e.getMessage();
                        if (message.toLowerCase().contains("java")) {
                            message = e.getMessage().substring(e.getMessage().indexOf(" "));
                        }
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                        username.requestFocus();
                    }
                }
            });
        }
    }

    public void redirectSignup(View view) {
        Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(i);
    }

    public void redirectIfLoggedIn() {
        if (ParseUser.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(" ");
        setContentView(R.layout.activity_login);
        AppCompatCheckBox checkBox=findViewById(R.id.showcheck);
        final EditText password =findViewById(R.id.password);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        redirectIfLoggedIn();
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}
