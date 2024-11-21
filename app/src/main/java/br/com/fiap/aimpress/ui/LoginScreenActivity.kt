package br.com.fiap.aimpress.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.aimpress.R
import br.com.fiap.aimpress.network.ApiClient
import br.com.fiap.aimpress.network.UsuarioService
import br.com.fiap.aimpress.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                realizarLogin(email, password)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun realizarLogin(email: String, password: String) {
        val usuarioService = ApiClient.retrofit.create(UsuarioService::class.java)
        val call = usuarioService.login(mapOf("email" to email, "password" to password))

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("LoginResponse", "Response code: ${response.code()}")
                Log.d("LoginResponse", "Response body: ${response.body()}")

                if (response.isSuccessful && response.body()?.success == true) {
                    // Login bem-sucedido
                    Toast.makeText(this@LoginScreenActivity, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginScreenActivity, UsuarioActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Usuário ou senha inválido
                    Toast.makeText(this@LoginScreenActivity, "Usuário ou senha inválido", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Erro de conexão ou outro problema de rede
                Log.e("LoginScreenActivity", "Erro ao fazer login", t)
                Toast.makeText(this@LoginScreenActivity, "Erro de conexão", Toast.LENGTH_SHORT).show()
            }
        })
    }
}