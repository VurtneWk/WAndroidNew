package com.vurtnewk.play

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.vurtnewk.play.databinding.ActivityMainBinding
import com.vurtnewk.play.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    private val mMainViewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment

        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        //用于控制系统自带的返回键
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home, R.id.knowledge_system, R.id.public_number, R.id.project)
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.viewmodel = mMainViewModel
        binding.lifecycleOwner = this

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home, R.id.knowledge_system, R.id.public_number, R.id.project -> {
                    mMainViewModel.setNavigationShow(true)
                }
                else -> {
                    mMainViewModel.setNavigationShow(false)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

}