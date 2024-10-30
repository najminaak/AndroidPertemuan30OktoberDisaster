package com.example.pertemuan30oktober

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan30oktober.databinding.ItemDisasterBinding

typealias OnClickDisaster = (Disaster) -> Unit

class DisasterAdapter(private val listDisaster: List<Disaster>,
    private val onClickDisaster: OnClickDisaster) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding
    : ItemDisasterBinding) :
            RecyclerView.ViewHolder(binding.root) {

                fun bind(data : Disaster) {
                    with(binding) {
                        txtDisasterName.text = data.name
                        txtDisasterType.text = data.type

                        // buat action
                        itemView.setOnClickListener {
                            onClickDisaster(data)
                        }
                    }
                }
            }

    // memanggil item disaster view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemDisasterViewHolder(binding)
    }

    // mengembalikan jumlah baris dari datanya
    override fun getItemCount(): Int {
        return listDisaster.size
    }


    // kalau sudah ada data, ini memilih data yang akan ditampilkan di baris dan letak tertentu
    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}