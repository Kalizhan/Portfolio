package com.example.protfolio.communicate;

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
import com.example.protfolio.aboutCollege.EmployeeActivity;
import com.example.protfolio.aboutCollege.NewsActivity;
import com.example.protfolio.aboutCollege.StudentActivity;
import com.example.protfolio.profile.LoginActivity;
import com.example.protfolio.profile.ProfileActivity;
import com.example.protfolio.profile.SignUpActivity;
import com.google.android.material.navigation.NavigationView;

public class ShareActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button btn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        btn_share = findViewById(R.id.share_button);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                intent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(intent, "Share using!"));
            }
        });

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
                intent = new Intent(ShareActivity.this, MainScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                intent = new Intent(ShareActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_student:
                intent = new Intent(ShareActivity.this, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_employee:
                intent = new Intent(ShareActivity.this, EmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                intent = new Intent(ShareActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(ShareActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signup:
                intent = new Intent(ShareActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(ShareActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_rate:
                intent = new Intent(ShareActivity.this, RateUsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_us:
                intent = new Intent(ShareActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}