package com.kortikoedu.kortiko.ui.video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.data.responses.Cegah
import com.kortikoedu.kortiko.databinding.VideoItemBinding

class CegahAdapter (
    private val callBack: (id: String) -> Unit
) : RecyclerView.Adapter<CegahAdapter.ViewHolder>() {

    private val list = listOf(
        Cegah("1", "Pencegahan kontraktur tangan", "Tahap 1"),
        Cegah("2", "Pencegahan kontraktur kaki", "Tahap 2"),
        Cegah("3", "Pencegahan lutut silang", "Tahap 3"),
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