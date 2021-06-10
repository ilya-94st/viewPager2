package com.example.staselovich_l13_t1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.staselovich_l13_t1.databinding.FragmentArticlesBinding


class ArticlesFragment : Fragment() {
  lateinit var binding: FragmentArticlesBinding

   var introSlidesRecucler2 = SliderAdapter2(
      arrayOf(
          IntroSlide2(Constants.TEXT_TITLE, Constants.TEXT_MAIN,Constants.TEXT_TIME, R.drawable.caption),
          IntroSlide2(Constants.TEXT_TITLE, Constants.TEXT_MAIN,Constants.TEXT_TIME2, R.drawable.kotlin),
          IntroSlide2(Constants.TEXT_TITLE, Constants.TEXT_MAIN,Constants.TEXT_TIME3, R.drawable.kotlin2)

      )
  )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false)




        binding.viewPager2.adapter = introSlidesRecucler2
        setUpIndecators()
        setCurrentIndicator(0)
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
            }
        })


        return binding.root
    }
    fun setUpIndecators() {
        val indicaors = arrayOfNulls<ImageView>(introSlidesRecucler2.itemCount)
        val layuotParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layuotParams.setMargins(8,0,8,0)
        for(i in indicaors.indices){
            indicaors[i] = ImageView(context?.applicationContext)
            indicaors[i].apply {
                this?.setImageDrawable(
                    context?.applicationContext?.let {
                        ContextCompat.getDrawable(
                            it, R.drawable.indicator_inactiv
                        )
                    }

                )
                this?.layoutParams = layuotParams
            }
            binding.intoroLayaut2.addView(indicaors[i])
        }
    }

    fun setCurrentIndicator(index: Int) {
        val childContayner = binding.intoroLayaut2.childCount
        for(i in 0 until childContayner){
            val imageView = binding.intoroLayaut2[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(context?.applicationContext?.let {
                    ContextCompat.getDrawable(
                        it, R.drawable.indicatar_activ
                    )
                })
            } else {
                imageView.setImageDrawable(context?.applicationContext?.let {
                    ContextCompat.getDrawable(
                        it, R.drawable.indicator_inactiv
                    )
                })
            }
        }
    }

}