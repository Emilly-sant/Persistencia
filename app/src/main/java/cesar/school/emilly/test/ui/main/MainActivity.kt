package cesar.school.emilly.test.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import cesar.school.emilly.test.R
import cesar.school.emilly.test.databinding.ActivityMainBinding
import cesar.school.emilly.test.ui.main.favorite.FavoriteFragment
import cesar.school.emilly.test.ui.main.search.SearchFragment
import cesar.school.emilly.test.ui.main.settings.SettingsPreferencesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val searchFragment = SearchFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsPreferencesFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_search -> setFragment(searchFragment)
                R.id.menu_favorite -> setFragment(favoriteFragment)
                R.id.menu_settings -> setFragment(settingsFragment)
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.menu_search
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerView.id, fragment)
            .addToBackStack(null)
            .commit()

    }
}

