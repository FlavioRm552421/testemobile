package br.com.fiap.aimpress.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.aimpress.R
import br.com.fiap.aimpress.model.Usuario

class UsuarioAdapter : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    private val usuarios = mutableListOf<Usuario>()

    fun setUsuarios(lista: List<Usuario>) {
        usuarios.clear()
        usuarios.addAll(lista)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeTextView: TextView = itemView.findViewById(R.id.nomeTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)

        fun bind(usuario: Usuario) {
            nomeTextView.text = usuario.nome
            emailTextView.text = usuario.email
        }
    }
}

