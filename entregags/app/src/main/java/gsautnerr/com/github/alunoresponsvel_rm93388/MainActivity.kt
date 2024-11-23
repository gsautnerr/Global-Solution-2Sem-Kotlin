package gsautnerr.com.github.alunoresponsvel_rm93388

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import gsautnerr.com.github.alunoresponsvel_rm93388.viewmodel.DicasAdapter
import gsautnerr.com.github.alunoresponsvel_rm93388.viewmodel.DicasViewModel
import gsautnerr.com.github.alunoresponsvel_rm93388.viewmodel.DicasViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DicasViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Dicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dicasAdapter = DicasAdapter { dica ->
            viewModel.removeDica(dica)
        }

        recyclerView.adapter = dicasAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescription)
        button.setOnClickListener {
            if (editTextTitle.text.isEmpty() || editTextDescription.text.isEmpty()) {
                editTextTitle.error = "Preencha o titulo"
                editTextDescription.error = "Preencha a descrição"
                return@setOnClickListener
            }

            viewModel.addDica(editTextTitle.text.toString(), editTextDescription.text.toString())
            editTextTitle.text.clear()
            editTextDescription.text.clear()
        }

        val viewModelFactory = DicasViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DicasViewModel::class.java)
        viewModel.dicasLiveData.observe(this) { dicas ->
            dicasAdapter.updateDicas(dicas)

        }
    }
}