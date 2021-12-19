package ru.mrlargha.sberhealthtest.presentation.fragment.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.databinding.MedicineViewBinding
import ru.mrlargha.sberhealthtest.model.Medicine

class MedicineAdapter(private val clickListener: MedicineClickListener) :
    ListAdapter<Medicine, MedicineAdapter.MedicineViewHolder>(MedicineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        return MedicineViewHolder.from(parent, clickListener)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MedicineViewHolder(
        itemView: View,
        private val medicineClickListener: MedicineClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        private var currentMedicine: Medicine? = null

        private val binding = MedicineViewBinding.bind(itemView).also {
            it.root.setOnClickListener {
                currentMedicine?.let { medicine ->
                    medicineClickListener.onMedicineClick(medicine)
                }
            }
        }

        fun bind(item: Medicine) {
            Picasso.get().load(item.icon).into(binding.medicineViewImage)
            currentMedicine = item
            binding.medicineViewMedicineName.text = item.title
        }

        companion object {
            fun from(parent: ViewGroup, listener: MedicineClickListener): MedicineViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.medicine_view, parent, false)
                return MedicineViewHolder(view, listener)
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