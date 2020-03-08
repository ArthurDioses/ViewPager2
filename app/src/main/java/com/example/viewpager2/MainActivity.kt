package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Sunlight",
                "Sunglight is the light and energy that from the sun",
                R.drawable.ic_launcher_background
            ),
            IntroSlide(
                "Pay Online",
                "Electrinic bill payment is a feature of online, mobile and telephone banking",
                R.drawable.ic_launcher_background
            ),
            IntroSlide(
                "Video Streaming",
                "Streaming media is multimedia that is constantly received by and presented to an end-user",
                R.drawable.ic_launcher_background
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpIntroSliderViewPager.adapter = introSliderAdapter
    }
}
