package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.client_example.R.id.toolbar
import com.example.client_example.databinding.ActivityNavDrawerBinding
import com.example.client_example.ui_fragments.AboutFragment
import com.example.client_example.ui_fragments.HomeFragment
import com.example.client_example.ui_fragments.SettingsFragment
import com.example.client_example.ui_fragments.ShareFragment
import com.google.android.material.navigation.NavigationView

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityNavDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        binding.navView.setNavigationItemSelectedListener(this)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.root, R.string.nav_open, R.string.nav_close)

        binding.apply {
            val notification = toolbar.findViewById<ImageView>(R.id.notification)
            notification.setOnClickListener {
                Toast.makeText(this@NavDrawerActivity, "Click notification", Toast.LENGTH_SHORT)
                    .show()
            }
            val headerView = navView.getHeaderView(0)
            val backBtn = headerView.findViewById<LinearLayout>(R.id.back_btn)
            backBtn.setOnClickListener {
                if (binding.root.isDrawerOpen(GravityCompat.START)) {
                    binding.root.closeDrawer(GravityCompat.START)
                }
                Toast.makeText(this@NavDrawerActivity, "OnBack", Toast.LENGTH_SHORT).show()
            }
            root.addDrawerListener(actionBarDrawerToggle)
            actionBarDrawerToggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setBackgroundDrawable(null)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger_menu)

        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()

            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment()).commit()

            R.id.nav_share -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareFragment()).commit()

            R.id.nav_about -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutFragment()).commit()

            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        binding.root.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.root.isDrawerOpen(GravityCompat.START)) {
            binding.root.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}