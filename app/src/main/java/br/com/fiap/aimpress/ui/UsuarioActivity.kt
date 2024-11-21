package br.com.fiap.aimpress.ui
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.aimpress.R
import br.com.fiap.aimpress.network.ApiClient
import br.com.fiap.aimpress.network.UsuarioService
import br.com.fiap.aimpress.model.Usuario
import br.com.fiap.aimpress.ui.UsuarioAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var usuarioAdapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        // Inicialize o RecyclerView e defina seu layout e adapter
        recyclerView = findViewById(R.id.recyclerViewUsuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        usuarioAdapter = UsuarioAdapter()
        recyclerView.adapter = usuarioAdapter

        // Chame o método para buscar os usuários
        listarUsuarios()
    }

    private fun listarUsuarios() {
        val usuarioService = ApiClient.retrofit.create(UsuarioService::class.java)
        val call = usuarioService.listarUsuarios()

        call.enqueue(object : Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                if (response.isSuccessful) {
                    val listaUsuarios = response.body()
                    if (listaUsuarios != null) {
                        // Atualize o adapter do RecyclerView com a lista de usuários
                        usuarioAdapter.setUsuarios(listaUsuarios)
                    } else {
                        Toast.makeText(this@UsuarioActivity, "Nenhum usuário encontrado", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Lide com erro de resposta
                    Toast.makeText(this@UsuarioActivity, "Erro: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                // Lide com falhas de rede
                Log.e("UsuarioActivity", "Erro ao buscar usuários", t)
                Toast.makeText(this@UsuarioActivity, "Erro de conexão", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
