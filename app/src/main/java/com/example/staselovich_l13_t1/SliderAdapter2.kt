package com.example.staselovich_l13_t1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SliderAdapter2(private val item: Array<IntroSlide2>): RecyclerView.Adapter<SliderAdapter2.MyHolder>() {
   inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      private val textView: TextView = itemView.findViewById(R.id.textTitle)
       private val textView2: TextView = itemView.findViewById(R.id.textMain)
       private val textView3: TextView = itemView.findViewById(R.id.timeText)
       private val imageView: ImageView = itemView.findViewById(R.id.imageView2)
       fun bind(introSlide2: IntroSlide2){
          textView.text = introSlide2.text1.toString()
          textView2.text = introSlide2.text2.toString()
          textView3.text = introSlide2.text3.toString()
           imageView.setImageResource(introSlide2.icon)

       }
   }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
       return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slide_contayner2,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bind(item[position])
    }

    override fun getItemCount(): Int {
     return item.size
    }

}