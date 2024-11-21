package br.com.fiap.aimpress.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.aimpress.R
import br.com.fiap.aimpress.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Configura os listeners dos botões
        setupListeners()

        return binding.root
    }

    private fun setupListeners() {
        binding.continueButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ForgotButton.setOnClickListener {
            // Navegar para o fragmento de esqueci minha senha
            findNavController().navigate(R.id.action_login_to_forgort)
        }
    }

    private fun loginUser(email: String, password: String) {
        // Implementar a lógica de login
        if (email == "teste" && password == "teste") {
            findNavController().navigate(R.id.navigation_home)
        } else {
            Toast.makeText(context, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}