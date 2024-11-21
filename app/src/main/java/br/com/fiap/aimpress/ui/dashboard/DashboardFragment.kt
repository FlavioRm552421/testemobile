package br.com.fiap.aimpress.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.aimpress.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example of initializing views
        val tvGreeting = view.findViewById<TextView>(R.id.tv_greeting)
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val cardCrieCurriculos = view.findViewById<CardView>(R.id.card_crie_curriculos)
        val cardDestaqueSe = view.findViewById<CardView>(R.id.card_destaque_se)
        val cardFeedback = view.findViewById<CardView>(R.id.card_feedback)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Example of setting data or configuring views
        tvGreeting.text = "Olá,"
        tvName.text = "Fernanda"

        // Example: Setting a click listener on a card
        cardCrieCurriculos.setOnClickListener {
            // Handle click event
        }

        cardDestaqueSe.setOnClickListener {
            // Handle click event
        }

        cardFeedback.setOnClickListener {
            // Handle click event
        }

        // Example: Configuring Bottom Navigation View
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle home navigation
                    true
                }
                R.id.navigation_dashboard -> {
                    // Handle dashboard navigation
                    true
                }
                R.id.navigation_notifications -> {
                    // Handle notifications navigation
                    true
                }
                else -> false
            }
        }
    }
}

