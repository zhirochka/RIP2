package com.example.rip2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rip2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    showLoginFragment()
    setContentView(binding.root)
  }

  override fun onBackPressed() {
    val fragment = supportFragmentManager.findFragmentByTag(HelloFragment.TAG)
    if (fragment != null && fragment.isVisible) {
      supportFragmentManager.popBackStack()
      showLoginFragment()
    } else {
      super.onBackPressed()
    }
  }

  private fun showLoginFragment() {
    supportFragmentManager.beginTransaction()
      .replace(R.id.holder, LoginFragment())
      .commit()
  }

  fun showHelloFragment(helloFragment: HelloFragment) {
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.holder, helloFragment, HelloFragment.TAG)
      .addToBackStack(null)
      .commit()
  }
}