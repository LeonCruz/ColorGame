package br.com.leon.colorgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.leon.colorgame.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        )
        binding.btnPlay.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }

        binding.btnRules.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_rulesFragment)
        }
        return return binding.root
    }
}