package com.example.myapplication

import ReceitaAdapter
import ReceitaViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val receitaViewModel: ReceitaViewModel by viewModels()
    private lateinit var adapter: ReceitaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtIngredientes = findViewById<EditText>(R.id.edtIngredientes)
        val edtModoPreparo = findViewById<EditText>(R.id.edtModoPreparo)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimparTudo = findViewById<Button>(R.id.btnLimparTudo)

        adapter = ReceitaAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        receitaViewModel.todasReceitas.observe(this) { receitas ->
            adapter.submitList(receitas)
        }

        btnSalvar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val ingredientes = edtIngredientes.text.toString()
            val modoPreparo = edtModoPreparo.text.toString()

            if (titulo.isNotEmpty() && ingredientes.isNotEmpty() && modoPreparo.isNotEmpty()) {
                val novaReceita = Receita(
                    titulo = titulo,
                    ingredientes = ingredientes,
                    modoPreparo = modoPreparo
                )
                receitaViewModel.inserir(novaReceita)
                edtTitulo.text.clear()
                edtIngredientes.text.clear()
                edtModoPreparo.text.clear()
            }
        }

        btnLimparTudo.setOnClickListener {
            receitaViewModel.deletarTudo()
        }
    }
}