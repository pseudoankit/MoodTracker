package lostankit7.droid.moodtracker.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import lostankit7.android.entry_presentation.AddUserEntryActivity
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core.presentation.utils.UiUtils.hide
import lostankit7.droid.moodtracker.core.presentation.utils.UiUtils.show
import lostankit7.droid.moodtracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController(R.id.fragment_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        setUpBottomNavigation()
    }

    private fun initListener() {
        binding.fabAddUserEntry.setOnClickListener { addEntryButtonClicked() }
    }

    private fun addEntryButtonClicked() {
        startActivity(Intent(this, AddUserEntryActivity::class.java))
    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavBar) {
            background = null
            menu.getItem(2).isEnabled = false
            setupWithNavController(navController)
        }
    }

    private fun showBottomNav() {
        binding.bottomLayout.show()
        binding.fragmentBottomGuide.show()
    }

    private fun hideBottomNav() {
        binding.bottomLayout.hide()
        binding.fragmentBottomGuide.hide()
    }
}