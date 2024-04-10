package com.anotn.antstock.android;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.anotn.antstock.android.fragment.HomeFragment;
import com.anotn.antstock.android.fragment.MyFragment;
import com.anotn.antstock.android.fragment.NewsFragment;
import com.anotn.antstock.android.fragment.ShopFragment;
import com.anotn.antstock.android.fragment.StockFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_home) {
                    menuItem.setChecked(true);
                    selectedFragment = new HomeFragment();
                } else if (itemId == R.id.nav_stock) {
                    selectedFragment =  new StockFragment();
                } else if (itemId == R.id.nav_news) {
                    selectedFragment = new NewsFragment();
                } else if (itemId == R.id.nav_shop) {
                    selectedFragment = new ShopFragment();
                } else {
                    selectedFragment = new MyFragment();
                }
                menuItem.setChecked(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_main, selectedFragment).commit();
                return false;
            }
        });
        if (savedInstanceState ==  null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }
}