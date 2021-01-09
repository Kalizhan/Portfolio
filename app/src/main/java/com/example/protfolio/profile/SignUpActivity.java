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

import com.example.protfolio.MainScreen;
import com.example.protfolio.R;
import com.example.protfolio.UserHelperClass;
import com.example.protfolio.aboutCollege.EmployeeActivity;
import com.example.protfolio.aboutCollege.NewsActivity;
import com.example.protfolio.aboutCollege.StudentActivity;
import com.example.protfolio.communicate.AboutUsActivity;
import com.example.protfolio.communicate.RateUsActivity;
import com.example.protfolio.communicate.ShareActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextInputLayout s_name, s_username, s_email, s_phoneNumber, s_password;
    Button callLogin, signUp;

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        s_name = findViewById(R.id.name);
        s_username = findViewById(R.id.username);
        s_email = findViewById(R.id.email);
        s_phoneNumber = findViewById(R.id.phoneNumber);
        s_password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUp);
        callLogin = findViewById(R.id.call_login);


        setSupportActionBar(toolbar);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
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
                intent = new Intent(SignUpActivity.this, MainScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                intent = new Intent(SignUpActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_student:
                intent = new Intent(SignUpActivity.this, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_employee:
                intent = new Intent(SignUpActivity.this, EmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signup:
                intent = new Intent(SignUpActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(SignUpActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_rate:
                intent = new Intent(SignUpActivity.this, RateUsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_us:
                intent = new Intent(SignUpActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    private Boolean validateEmail() {
        String email = s_email.getEditText().getText().toString();
        String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        if (email.isEmpty()) {
            s_email.setError("Email bos bolmauy kerek!");
            return false;
        } else if (!email.matches(emailPattern)) {
            s_email.setError("Email adresin'iz durys emes");
            return false;
        } else {
            s_email.setError(null);
            s_email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String username = s_username.getEditText().getText().toString();
        String noWhiteSpace = ".*\\S+.*";

        if (username.isEmpty()) {
            s_username.setError("Esimin'iz bos bolmauy kerek!");
            return false;
        } else if (username.length() >= 15) {
            s_username.setError("Nickname o'te uzaq");
            return false;
        } else if (!username.matches(noWhiteSpace)) {
            s_username.setError("Probel qabyldanbaidy");
            return false;
        } else {
            s_username.setError(null);
            s_username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateName() {
        String name = s_name.getEditText().getText().toString();

        if (name.isEmpty()) {
            s_name.setError("Atyn'z bos bolmauy kerek!");
            return false;
        }
        else {
            s_name.setError(null);
            s_name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String phoneNumber = s_phoneNumber.getEditText().getText().toString();

        if (phoneNumber.isEmpty()) {
            s_phoneNumber.setError("Telefon no'merin'iz bos bolmauy kerek!");
            return false;
        } else {
            s_phoneNumber.setError(null);
            s_phoneNumber.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String password = s_password.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +       //at least 1 digit
                //"(?=.*[a-z])" +       //at least 1 lower case letter
                //"(?=.*[A_Z])" +       //at least 1 upper case letter
                "(?=.*[a-zA_Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (password.isEmpty()) {
            s_password.setError("Parolin'iz bos bolmauy kerek!");
            return false;
        } else if (!password.matches(passwordVal)) {
            s_password.setError("Parolin'iz tym on'ai");
            return false;
        } else {
            s_password.setError(null);
            s_password.setErrorEnabled(false);
            return true;
        }
    }

    //This function will execute when user click on Register Button
    public void registerUser(View view) {

        if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()){
            return;
        }else{
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database = FirebaseDatabase.getInstance();
                    myRef = database.getReference("users");

                    String name = s_name.getEditText().getText().toString();
                    String username = s_username.getEditText().getText().toString();
                    String email = s_email.getEditText().getText().toString();
                    String phoneNumber = s_phoneNumber.getEditText().getText().toString();
                    String password = s_password.getEditText().getText().toString();


                    UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNumber, password);


                    myRef.child(username).setValue(helperClass);
                    Intent intent = new Intent(SignUpActivity.this, MainScreen.class);
                    startActivity(intent);
                }
            });
        }

    }
}