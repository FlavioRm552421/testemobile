package br.com.fiap.aimpress.network

import br.com.fiap.aimpress.model.LoginResponse
import br.com.fiap.aimpress.model.Usuario
import retrofit2.Call
import retrofit2.http.*

interface UsuarioService {
    @POST("usuarios")
    fun criarUsuario(@Body usuario: Usuario): Call<Usuario>

    @GET("usuarios")
    fun listarUsuarios(): Call<List<Usuario>>

    @PUT("usuarios/{id}")
    fun atualizarUsuario(@Path("id") id: Int, @Body usuario: Usuario): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun deletarUsuario(@Path("id") id: Int): Call<Void>

    // Endpoint de login - substitua "login" pelo caminho correto se necessário
    @POST("login")
    fun login(@Body loginRequest: Map<String, String>): Call<LoginResponse>
}



