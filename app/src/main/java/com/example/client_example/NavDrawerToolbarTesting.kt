package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.client_example.databinding.ActivityNavDrawerToolbarTestingBinding
import com.example.client_example.ui_fragments.AboutFragment
import com.example.client_example.ui_fragments.HomeFragment
import com.example.client_example.ui_fragments.SettingsFragment
import com.example.client_example.ui_fragments.ShareFragment
import com.google.android.material.navigation.NavigationView

class NavDrawerToolbarTesting : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityNavDrawerToolbarTestingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavDrawerToolbarTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_)
        setSupportActionBar(toolbar)

        val navView = findViewById<NavigationView>(R.id.nav_view_)
        navView.setNavigationItemSelectedListener(this)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(null)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger_menu)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment()).commit()
            }

            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SettingsFragment()).commit()
            }

            R.id.nav_share -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ShareFragment()).commit()
            }

            R.id.nav_about -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AboutFragment()).commit()
            }

            R.id.nav_logout -> {
                Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}