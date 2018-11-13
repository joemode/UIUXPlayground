package com.schoenherr.uiuxplayground.ui

import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.MenuItem
import com.schoenherr.uiuxplayground.databinding.ActivityMainBinding
import androidx.core.view.GravityCompat
import com.schoenherr.uiuxplayground.ui.recyclergrid.GridRecyclerFragment
import androidx.appcompat.app.ActionBarDrawerToggle
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.ui.styledmap.StyledMapFragment


/**
 * For the handling of UI/UX playground fragments
 */
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainViewModel(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        val drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_closed
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        setupDrawer()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawer() {
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            return@setNavigationItemSelectedListener true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        val fragmentClass : Class<*> = when (menuItem.itemId) {
            R.id.navigation_first -> { GridRecyclerFragment::class.java }
            R.id.navigation_second -> { StyledMapFragment::class.java }
            else -> { GridRecyclerFragment::class.java }
        }

        val fragment = (fragmentClass.newInstance() as Fragment)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, fragment)
            .disallowAddToBackStack()
            .commit()

        menuItem.isChecked = true
        title = menuItem.title
        binding.drawerLayout.closeDrawers()
    }
}
