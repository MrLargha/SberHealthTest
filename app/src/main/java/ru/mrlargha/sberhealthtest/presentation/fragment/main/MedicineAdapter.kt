package ru.mrlargha.sberhealthtest.presentation.fragment.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.mrlargha.sberhealthtest.R
import ru.mrlargha.sberhealthtest.databinding.MedicineViewBinding
import ru.mrlargha.sberhealthtest.model.Medicine

class MedicineAdapter(private val clickListener: MedicineClickListener) :
    RecyclerView.Adapter<MedicineAdapter.BaseViewHolder>() {

    companion object {
        private const val TITLE = 0
        private const val MEDICINE = 1
    }

    private var currentList = listOf<Medicine>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return if (viewType == MEDICINE) MedicineViewHolder.from(parent, clickListener) else
            return TitleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (getItemViewType(position) == MEDICINE)
            (holder as MedicineViewHolder).bind(currentList[position - 1])
    }

    override fun getItemViewType(position: Int) = if (position > 0) MEDICINE else TITLE

    override fun getItemCount() = currentList.size + 1

    fun submitList(list: List<Medicine>) {
        currentList = list
        // Никаких микро-изменений в рамках данного задания у нас, поэтому считаем, что у нас меняется весь список разом
        notifyDataSetChanged()
    }

    sealed class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class MedicineViewHolder(
        itemView: View,
        private val medicineClickListener: MedicineClickListener
    ) : BaseViewHolder(itemView) {

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
            fun from(parent: ViewGroup, listener: MedicineClickListener): BaseViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.medicine_view, parent, false)
                return MedicineViewHolder(view, listener)
            }
        }
    }

    class TitleViewHolder(itemView: View) : BaseViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup): BaseViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.medicine_list_title_view, parent, false)
                return TitleViewHolder(view)
            }
        }
    }
}
