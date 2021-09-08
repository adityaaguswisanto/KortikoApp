package com.kortikoedu.kortiko.ui.video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.data.responses.Motor
import com.kortikoedu.kortiko.databinding.VideoItemBinding

class MotorAdapter (
    private val callBack: (id: String) -> Unit
) : RecyclerView.Adapter<MotorAdapter.ViewHolder>() {

    private val list = listOf(
        Motor("1", "Mulut Selalu terbuka", "Tahap 1"),
        Motor("2", "Belum mengunyah", "Tahap 2"),
        Motor("3", "Air liur sering menetes", "Tahap 3"),
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