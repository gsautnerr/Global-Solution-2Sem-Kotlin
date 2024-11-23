package gsautnerr.com.github.alunoresponsvel_rm93388.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gsautnerr.com.github.alunoresponsvel_rm93388.R
import gsautnerr.com.github.alunoresponsvel_rm93388.model.DicaModel

class DicasAdapter(private val onDicaRemoved: (DicaModel) -> Unit) :
    RecyclerView.Adapter<DicasAdapter.DicaViewHolder>() {

    private var dicas = listOf<DicaModel>()

    inner class DicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle = view.findViewById<TextView>(R.id.textViewDica)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewTipsDescription)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(item: DicaModel) {
             textViewTitle.text = item.name
            textViewDescription.text = item.desc

            button.setOnClickListener {
                onDicaRemoved(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dica_layout, parent, false)
        return DicaViewHolder(view)
    }
    override fun getItemCount(): Int = dicas.size

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.bind(dica)
    }

    fun updateDicas(newdicas: List<DicaModel>) {
        dicas = newdicas
        notifyDataSetChanged()
    }
}