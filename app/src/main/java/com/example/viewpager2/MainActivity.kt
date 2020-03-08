package com.example.viewpager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Sunlight",
                "Sunglight is the light and energy that from the sun",
                R.drawable.ic_sunlight
            ),
            IntroSlide(
                "Pay Online",
                "Electrinic bill payment is a feature of online, mobile and telephone banking",
                R.drawable.ic_payonline
            ),
            IntroSlide(
                "Video Streaming",
                "Streaming media is multimedia that is constantly received by and presented to an end-user",
                R.drawable.ic_videostreaming
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpIntroSliderViewPager.adapter = introSliderAdapter
        setupIndicator()
        setCurrentIndicator(0)
        vpIntroSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        btnNext.setOnClickListener {
            if (vpIntroSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                vpIntroSliderViewPager.currentItem += 1
            } else {
                Intent(applicationContext, AnotherActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        tvSkipIntro.setOnClickListener {
            Intent(applicationContext, AnotherActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun setupIndicator() {
        val indicator = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicator.indices) {
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.ic_circleinactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            llIndicatorContainer.addView(indicator[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = llIndicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = llIndicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.ic_circleactive
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.ic_circleinactive
                    )
                )
            }

        }
    }
}
