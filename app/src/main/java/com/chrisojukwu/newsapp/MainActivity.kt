package com.chrisojukwu.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.chrisojukwu.newsapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //stretch windows to edge
        WindowCompat.setDecorFitsSystemWindows(window, false)


        //prevent phone keyboard from pushing up page
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        //set custom toolbar as ActionBar
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val bottomNavView: BottomNavigationView = binding.bottomNav

        //list of fragments that should be regarded as first level destinations
        //this tells the navController to remove the up navigate button from these destinations
        val appBarConfiguration = AppBarConfiguration
            .Builder(R.id.homePageContainerFragment, R.id.watchFragment, R.id.scoresFragment, R.id.sportsFragment)
            .build()

        //setup navController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        //link the navController to the bottomNav for navigation
        NavigationUI.setupWithNavController(bottomNavView, navController)

        //link the appBarConfiguration to the navController
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    //call the navController to handle up button clicks from the ActionBar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
