package com.kortikoedu.kortiko.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.R
import com.kortikoedu.kortiko.data.responses.Main
import com.kortikoedu.kortiko.databinding.MainItemBinding

class MainAdapter (
    private val callBack: (name: String) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val list = listOf(
        Main("1", "Masalah Kesehatan Umum", R.drawable.umum),
        Main("2", "Motorik Kasar", R.drawable.kasar),
        Main("3", "Motorik Halus", R.drawable.halus),
        Main("4", "Oral Motor", R.drawable.motor),
        Main("5", "Terapi Pencegahan", R.drawable.cegah),
        Main("6", "Alat Bantu", R.drawable.bantu),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            cv.setOnClickListener { callBack.invoke(item.name) }
            txtTitle.text = item.title
            imageView.setImageDrawable(ContextCompat.getDrawable(root.context, item.imageId))
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = MainItemBinding.bind(view)
    }
}