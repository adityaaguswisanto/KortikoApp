package com.kortikoedu.kortiko.ui.video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.data.responses.Kasar
import com.kortikoedu.kortiko.databinding.VideoItemBinding

class KasarAdapter (
    private val callBack: (id: String) -> Unit
) : RecyclerView.Adapter<KasarAdapter.ViewHolder>() {

    private val list = listOf(
        Kasar("1", "Belum menegakkan kepala", "Tahap 1"),
        Kasar("2", "Belum duduk", "Tahap 2"),
        Kasar("3", "Belum merangkak", "Tahap 3"),
        Kasar("4", "Kaki jinjit", "Tahap 4"),
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