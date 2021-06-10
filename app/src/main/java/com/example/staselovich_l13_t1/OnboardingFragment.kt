package com.example.staselovich_l13_t1

import android.content.Context
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.staselovich_l13_t1.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
    lateinit var binding: FragmentOnboardingBinding
    private var introSlideswRecucler = SliderAdapter(
            listOf(
                IntroSlide("Перейти на страницу 1",
                R.drawable.book1
                    ), IntroSlide(
                    "Перейти на страницу 2",
                    R.drawable.book2
                    ),
                IntroSlide("Перейти на страницу 3",
                    R.drawable.book3)
            )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)



  binding.viewPager.adapter = introSlideswRecucler
        setUpIndecators()
        setCurrentIndicator(0)
        binding.viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                setCurrentIndicator(position)
            }
        })
        return binding.root


    }
    fun setUpIndecators() {
        val indicaors = arrayOfNulls<ImageView>(introSlideswRecucler.itemCount)
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
            binding.indcatorLayout.addView(indicaors[i])
        }
    }

    fun setCurrentIndicator(index: Int) {
        val childContayner = binding.indcatorLayout.childCount
        for(i in 0 until childContayner){
val imageView = binding.indcatorLayout[i] as ImageView
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