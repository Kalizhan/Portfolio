package com.example.protfolio.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.protfolio.MainScreen;
import com.example.protfolio.R;
import com.example.protfolio.aboutCollege.EmployeeActivity;
import com.example.protfolio.aboutCollege.NewsActivity;
import com.example.protfolio.aboutCollege.StudentActivity;
import com.example.protfolio.communicate.AboutUsActivity;
import com.example.protfolio.communicate.RateUsActivity;
import com.example.protfolio.communicate.ShareActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextInputLayout s_name, s_password;
    Button callSignUp, login;
    CheckBox rememberMe;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        callSignUp = findViewById(R.id.call_sign_up);
        login = findViewById(R.id.login);
        s_name = findViewById(R.id.username);
        s_password = findViewById(R.id.password);
        rememberMe = findViewById(R.id.remember_me);



        setSupportActionBar(toolbar);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        callSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.nav_about_college:
                intent = new Intent(LoginActivity.this, MainScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                intent = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_student:
                intent = new Intent(LoginActivity.this, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_employee:
                intent = new Intent(LoginActivity.this, EmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                intent = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signup:
                intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(LoginActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_rate:
                intent = new Intent(LoginActivity.this, RateUsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_us:
                intent = new Intent(LoginActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    private Boolean validateUsername(){
        String name = s_name.getEditText().getText().toString();

        if(name.isEmpty()){
            s_name.setError("Atyn'z bos bolmauy kerek!");
            return false;
        }else{
            s_name.setError(null);
            s_name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String password = s_password.getEditText().getText().toString();

        if(password.isEmpty()){
            s_password.setError("Parol bos bolmauy kerek!");
            return false;
        }else{
            s_password.setError(null);
            s_password.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View v){
        if(!validatePassword() | !validateUsername()){
            return;
        }else{
            isUser();
        }
    }

    private void isUser(){
        String userEnteredName = s_name.getEditText().getText().toString().trim();
        String userEnteredPassword = s_password.getEditText().getText().toString().trim();

        myRef = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = myRef.orderByChild("username").equalTo(userEnteredName);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    s_name.setError(null);
                    s_name.setErrorEnabled(false);

                    String passwordFromDB = snapshot.child(userEnteredName).child("password").getValue(String.class);

                    if(passwordFromDB.equals(userEnteredPassword)){
                        s_name.setError(null);
                        s_name.setErrorEnabled(false);

                        String nameFromDB = snapshot.child(userEnteredPassword).child("name").getValue(String.class);
                        String usernameFromDB = snapshot.child(userEnteredPassword).child("username").getValue(String.class);
                        String phoneNumberFromDB = snapshot.child(userEnteredPassword).child("phoneNumber").getValue(String.class);
                        String emailFromDB = snapshot.child(userEnteredPassword).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), MainScreen.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        intent.putExtra("phoneNumber", phoneNumberFromDB);
                        intent.putExtra("email", emailFromDB);

                        startActivity(intent);
                    }else{
                        s_password.setError("Qate parol");
                        s_password.requestFocus();
                    }
                }else{
                    s_name.setError("Bundai at zhok");
                    s_name.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}