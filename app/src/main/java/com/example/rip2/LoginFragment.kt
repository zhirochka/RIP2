package com.example.rip2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rip2.databinding.FragmentLoginBinding
import org.json.JSONArray

class LoginFragment : Fragment() {
  private lateinit var binding: FragmentLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val json = JsonUtils.loadJsonFromAsset(requireActivity(), "data.json")
    val arrayList = parseJson(json)
    binding = FragmentLoginBinding.inflate(inflater, container, false)
    binding.button.setOnClickListener {
      val login = binding.editTextText.text.toString()
      val password = binding.editTextTextPassword.text.toString()
      val foundUser = arrayList.find { it.login == login && it.password == password }
      if (foundUser != null) {
        val helloFragment = HelloFragment.newInstance(foundUser.login)
        (activity as MainActivity).showHelloFragment(helloFragment)
      } else
        Toast.makeText(context, "Неверные данные", Toast.LENGTH_SHORT).show()
    }
    return binding.root
  }

  private fun parseJson(jsonArray: JSONArray?): List<User> {
    val dataList = mutableListOf<User>()

    jsonArray?.let {
      for (i in 0 until it.length()) {
        val jsonObject = it.getJSONObject(i)
        val login = jsonObject.getString("login")
        val password = jsonObject.getString("password")

        val user = User(login, password)
        dataList.add(user)
      }
    }

    return dataList
  }

  companion object {
    @JvmStatic
    fun newInstance() =
      LoginFragment()
  }
}