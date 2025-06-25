import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Receita


class ReceitaAdapter : ListAdapter<Receita, ReceitaAdapter.ReceitaViewHolder>(ReceitaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receita, parent, false)
        return ReceitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ReceitaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        private val txtIngredientes: TextView = itemView.findViewById(R.id.txtIngredientes)
        private val txtModoPreparo: TextView = itemView.findViewById(R.id.txtModoPreparo)

        fun bind(receita: Receita) {
            txtTitulo.text = receita.titulo
            txtIngredientes.text = "Ingredientes: ${receita.ingredientes}"
            txtModoPreparo.text = "Modo de Preparo: ${receita.modoPreparo}"
        }
    }

    class ReceitaDiffCallback : DiffUtil.ItemCallback<Receita>() {
        override fun areItemsTheSame(oldItem: Receita, newItem: Receita): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receita, newItem: Receita): Boolean {
            return oldItem == newItem
        }
    }
}
