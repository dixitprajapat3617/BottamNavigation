package com.app.bottamnavigation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.bottamnavigation2.Fragment.*
import com.app.bottamnavigation2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolBar.title = "Home"

        addFragment(HomeFragment(), "Home")

        binding.bottamNavigation.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when(it.itemId){
                R.id.bottam_home -> {
                    addFragment(HomeFragment(), "Home")
                    true
                }
                R.id.bottam_search -> {
                    addFragment(SearchFragment(), "Search")
                    true
                }
                R.id.bottam_favorite -> {
                    addFragment(FavoriteFragment(), "Favroite")
                    true
                }
                R.id.bottam_my_Order -> {
                    addFragment(MyorderFragment(), "Order")
                    true
                }
                R.id.bottam_profile -> {
                    addFragment(ProfileFragment(), "Profile")
                    true
                }
                else -> {
                    false
                }
            }
        }

    }



    fun addFragment(fragment: Fragment, title:String){
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_conainer, fragment)
        transaction.addToBackStack(title)
        transaction.commit()

        binding.toolBar.title = "$title"

    }
}





