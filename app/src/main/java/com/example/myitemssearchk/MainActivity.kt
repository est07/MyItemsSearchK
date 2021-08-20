package com.example.myitemssearchk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.myitemssearchk.presentation.viewModels.ItemSearchDataViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
