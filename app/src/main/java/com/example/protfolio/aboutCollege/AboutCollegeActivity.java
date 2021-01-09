package com.example.protfolio.aboutCollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.protfolio.MainScreen;
import com.example.protfolio.R;
import com.example.protfolio.communicate.AboutUsActivity;
import com.example.protfolio.communicate.RateUsActivity;
import com.example.protfolio.communicate.ShareActivity;
import com.example.protfolio.profile.LoginActivity;
import com.example.protfolio.profile.ProfileActivity;
import com.example.protfolio.profile.SignUpActivity;
import com.google.android.material.navigation.NavigationView;

public class AboutCollegeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
                intent = new Intent(AboutCollegeActivity.this, MainScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                intent = new Intent(AboutCollegeActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_student:
                intent = new Intent(AboutCollegeActivity.this, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_employee:
                intent = new Intent(AboutCollegeActivity.this, EmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                intent = new Intent(AboutCollegeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(AboutCollegeActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signup:
                intent = new Intent(AboutCollegeActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(AboutCollegeActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_rate:
                intent = new Intent(AboutCollegeActivity.this, RateUsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_us:
                intent = new Intent(AboutCollegeActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}