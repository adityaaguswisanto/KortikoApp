package com.kortikoedu.kortiko.ui.video.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kortikoedu.kortiko.data.responses.Umum
import com.kortikoedu.kortiko.databinding.VideoItemBinding

class UmumAdapter(
    private val callBack: (id: String) -> Unit
) : RecyclerView.Adapter<UmumAdapter.ViewHolder>() {

    private val list = listOf(
        Umum("1", "Kagetan dan sensitif suara", "Tahap 1"),
        Umum("2", "Susah tidur malam hari", "Tahap 2"),
        Umum("3", "Sembelit", "Tahap 3"),
        Umum("4", "Lendir di saluran pernafasan", "Tahap 4")
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