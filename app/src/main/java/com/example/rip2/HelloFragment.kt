package com.example.rip2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rip2.databinding.FragmentHelloBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
class HelloFragment : Fragment() {
  // TODO: Rename and change types of parameters
  private var param1: String? = null
  private lateinit var binding: FragmentHelloBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      param1 = it.getString(ARG_PARAM1)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHelloBinding.inflate(inflater, container, false)
    binding.textView.text = context?.getString(R.string.hello_text, param1) ?: "Hello"
    return binding.root
  }

  companion object {
    const val TAG = "HelloFragment"

    @JvmStatic
    fun newInstance(param1: String) =
      HelloFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
        }
      }
  }
}