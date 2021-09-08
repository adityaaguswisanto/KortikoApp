package com.kortikoedu.kortiko.ui.video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.data.responses.Bantu
import com.kortikoedu.kortiko.databinding.VideoItemBinding

class BantuAdapter (
    private val callBack: (id: String) -> Unit
) : RecyclerView.Adapter<BantuAdapter.ViewHolder>() {

    private val list = listOf(
        Bantu("1", "Collar Leher", "Tahap 1"),
        Bantu("2", "Standing frame", "Tahap 2"),
        Bantu("3", "Korset", "Tahap 3"),
        Bantu("4", "AFO", "Tahap 4"),
        Bantu("5", "Cook up splint", "Tahap 5"),
        Bantu("6", "Splint tangan dan kaki", "Tahap 6"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            VideoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            constrainLayout.setOnClickListener { callBack.invoke(item.id) }
            txtNo.text = item.id
            txtTitle.text = item.title
            txtTahap.text = item.tahap
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = VideoItemBinding.bind(view)
    }
}