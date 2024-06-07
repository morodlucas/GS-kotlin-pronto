package br.com.fiap.lucasdiasmorosinirm94523

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()


    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val praia = view.findViewById<TextView>(R.id.NomePraia)
        val estado = view.findViewById<TextView>(R.id.Estado)
        val cidade = view.findViewById<TextView>(R.id.Cidade)
        val button = view.findViewById<Button>(R.id.Excluir)

        fun bind(item: ItemModel) {
            praia.text = item.praiaName
            estado.text = item.estadoName
            cidade.text = item.cidadeName

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}