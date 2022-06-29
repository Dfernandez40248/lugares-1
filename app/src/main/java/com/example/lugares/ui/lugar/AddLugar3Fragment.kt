package com.example.lugares.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.lugares.R
import com.example.lugares.databinding.FragmentAddLugar3Binding
import com.example.lugares.databinding.FragmentAddLugarBinding
import com.example.lugares.model.Lugar
import com.example.lugares.viewmodel.LugarViewModel


class AddLugar3Fragment : Fragment() {
    private var _binding: FragmentAddLugar3Binding? = null
    private val binding get() = _binding!!

    private lateinit var lugarViewModel: LugarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddLugar3Binding.inflate(inflater, container, false)

        lugarViewModel = ViewModelProvider(this).get(LugarViewModel::class.java)
        binding.btnsubmit3.setOnClickListener{ addLugar()}


        return binding.root

    }

    private fun addLugar() {
        val nombre = binding.lugarName3.text.toString()

        if (validation(nombre)){
            //guardar lugar
            val lugar = Lugar(0, nombre)
            lugarViewModel.addLugar(lugar)
            Toast.makeText(requireContext(), getString(R.string.msg_lugar_added),Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(), getString(R.string.msg_error),Toast.LENGTH_LONG).show()
        }
    }

    private fun validation(nombre: String): Boolean {
        return !(nombre.isEmpty())
    }
}