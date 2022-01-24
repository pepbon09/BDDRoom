package com.example.basededatossql

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AmigosAdapter(
    private val context: Context,
    private val dataset: List<MisAmigos>
    ) : RecyclerView.Adapter<AmigosAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.item_name)
        val txtEmail: TextView = view.findViewById(R.id.item_email)
        val txtId: TextView = view.findViewById(R.id.item_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.txtName.text = item.nombre
        holder.txtEmail.text = item.email
        holder.txtId.text = "ID: ${item.id}"
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}