package com.example.myitemssearchk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        val navController =
            supportFragmentManager
                .findFragmentById(R.id.fraNavigationItemSearch) as NavHostFragment
        navController.navController
    }
}
