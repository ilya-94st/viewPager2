package com.example.staselovich_l13_t1

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SliderAdapter(private val introSlides: List<IntroSlide>) : RecyclerView.Adapter<SliderAdapter.InerViewHolder>() {
    inner class InerViewHolder(view: View): RecyclerView.ViewHolder(view){
       private val textView: TextView = view.findViewById(R.id.textTitle)
       private val imageView: ImageView = view.findViewById(R.id.imageView)

        fun bind(introSlide: IntroSlide) {
            textView.text = introSlide.title
            imageView.setImageResource(introSlide.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerViewHolder {
return InerViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.slide_conteyner,parent,false)
)
    }

    override fun onBindViewHolder(holder: InerViewHolder, position: Int) {
holder.bind(introSlides[position])

    }

    override fun getItemCount(): Int {
return introSlides.size
    }
}