package br.com.fiap.lucasdiasmorosinirm94523

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.lucasdiasmorosinirm94523.ui.theme.LucasDiasMorosiniRM94523Theme


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsAdapter = ItemsAdapter()

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        recycler.adapter = itemsAdapter

        val praia = findViewById<EditText>(R.id.AddPraia)
        val estado = findViewById<EditText>(R.id.AddEstado)
        val cidade = findViewById<EditText>(R.id.AddCidade)


        val button = findViewById<Button>(R.id.incluir)

        button.setOnClickListener{
            if(praia.text.isEmpty()){
                praia.error = "O valor não pode ficar vazio!"
                return@setOnClickListener
            }
            if(estado.text.isEmpty()){
                estado.error = "O valor não pode ficar vazio!"
                return@setOnClickListener
            }
            if(cidade.text.isEmpty()){
                cidade.error = "O valor não pode ficar vazio!"
                return@setOnClickListener
            }

            val item = ItemModel(
                praiaName = praia.text.toString(),
                estadoName = estado.text.toString(),
                cidadeName = cidade.text.toString(),
                onRemove ={
                    itemsAdapter.removeItem(it)
                }
            )
            itemsAdapter.addItem(item)


            praia.text.clear()
            estado.text.clear()
            cidade.text.clear()
        }

        //tentativa de fazer o botão de voltar funcionar, mas quando ele volta para a main, as funcionalidades dela não
        //se fazem mais presentes
        val integrantes = findViewById<Button>(R.id.buttonIntegrantes)

        integrantes.setOnClickListener {
            setContentView(R.layout.nome_integrantes)
            val voltar = findViewById<Button>(R.id.buttonVoltar)
            voltar.setOnClickListener {
                setContentView(R.layout.activity_main)
            }
        }

    }
}