package br.com.leon.colorgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.leon.colorgame.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRulesBinding>(
            inflater, R.layout.fragment_rules, container, false
        )

        binding.btnBackHomeFromRules.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rulesFragment_to_homeFragment)
        }

        binding.btnPlayFromRules.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rulesFragment_to_gameFragment)
        }

        return binding.root
    }
}