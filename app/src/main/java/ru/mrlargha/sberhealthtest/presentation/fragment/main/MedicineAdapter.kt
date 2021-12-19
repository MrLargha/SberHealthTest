package ru.mrlargha.sberhealthtest.presentation.fragment.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.model.Medicine

class MedicineAdapter :
    ListAdapter<Medicine, MedicineAdapter.MedicineViewHolder>(MedicineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        return MedicineViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Medicine) {
            TODO("Build view holder here")
        }


        companion object {
            fun from(parent: ViewGroup): MedicineViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.medicine_view, parent, false)
                return MedicineViewHolder(view)
            }
        }
    }
}

class MedicineDiffCallback : DiffUtil.ItemCallback<Medicine>() {
    override fun areItemsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
        return oldItem == newItem
    }
}