package com.example.parseauthentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private void Logout_AlertBox(){
        AlertDialog.Builder abuilder = new AlertDialog.Builder(MainActivity.this)
                .setMessage("Do you want to Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ParseUser.logOut();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = abuilder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(" ");
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        TextView username = findViewById(R.id.username);
        ParseUser currentuser = ParseUser.getCurrentUser();
        if(currentuser!=null)
        {
            username.setText(currentuser.getString("username"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater optmenu =getMenuInflater();
        optmenu.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Logout_AlertBox();
                break;
        }
        return true;
    }
}