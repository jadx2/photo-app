package com.example.photoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.photoapp.appContainer.AppContainer
import com.example.photoapp.appContainer.DetailViewContainer
import com.example.photoapp.appContainer.OverviewContainer
import com.example.photoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (application as MyApplication).appContainer
        appContainer.overviewContainer = OverviewContainer(appContainer.photosRepository)
        appContainer.detailViewContainer = DetailViewContainer(appContainer.photosRepository)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.overviewContainer = null
        appContainer.detailViewContainer = null
    }
}