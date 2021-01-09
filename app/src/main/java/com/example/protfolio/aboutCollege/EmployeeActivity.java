package com.example.protfolio.aboutCollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.protfolio.Contact;
import com.example.protfolio.Employee;
import com.example.protfolio.MainScreen;
import com.example.protfolio.R;
import com.example.protfolio.adapters.ContactListAdapter;
import com.example.protfolio.adapters.EmployeeListAdapter;
import com.example.protfolio.communicate.AboutUsActivity;
import com.example.protfolio.communicate.RateUsActivity;
import com.example.protfolio.communicate.ShareActivity;
import com.example.protfolio.profile.LoginActivity;
import com.example.protfolio.profile.ProfileActivity;
import com.example.protfolio.profile.SignUpActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView recyclerView;
    EmployeeListAdapter employeeListAdapter;
    ArrayList<Employee> employeeArrayList;
    private RecyclerView.LayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);recyclerView = findViewById(R.id.recyclerview);
        employeeArrayList = new ArrayList<>();
        employeeListAdapter = new EmployeeListAdapter(this, employeeArrayList);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeListAdapter);

        employeeArrayList.add(new Employee("Bakhytzhan Myktybaev", "Java, android, mobail developer, IT-teacher", "Studied in SDU, teached there," +
                "worked in another companies, have a lot of skills!"));
        employeeArrayList.add(new Employee("Talgat Kulkeyev", "Java teacher", "Studied in SDU, teached there, now in JIHC"));
        employeeArrayList.add(new Employee("Bakytzhan Kazangapov", "UI/UX designer, Adobe, teacher", "Studied in London, " +
                "teaching in JIHC"));

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
                intent = new Intent(EmployeeActivity.this, MainScreen.class);
                startActivity(intent);
                break;
            case R.id.nav_news:
                intent = new Intent(EmployeeActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_student:
                intent = new Intent(EmployeeActivity.this, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_employee:
                intent = new Intent(EmployeeActivity.this, EmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                intent = new Intent(EmployeeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent = new Intent(EmployeeActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_signup:
                intent = new Intent(EmployeeActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(EmployeeActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_rate:
                intent = new Intent(EmployeeActivity.this, RateUsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_us:
                intent = new Intent(EmployeeActivity.this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}