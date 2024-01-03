package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.client_example.databinding.ActivityCircularProgressBinding
import xyz.schwaab.avvylib.AvatarView

class CircularProgressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCircularProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCircularProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            progress.setProgress(66f, false, 1000)

            /*avatarView2.animationOrchestrator = CrazyOrchestrator.create()
            buttonToggleHighlight.setOnClickListener {

                *//*updateAvatars {
                        isHighlighted = !isHighlighted
                    }*//*
            }
            buttonToggleProgress.setOnClickListener {
                updateAvatars {
                    isAnimating = !isAnimating
                }
            }*/

        }

        /*val archesExpansion = object : AvatarViewAnimator {
            override val baseAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
                duration = 5000L
                interpolator = DecelerateInterpolator()
            }

            override fun onValueUpdate(animatorInterface: AvatarView.AnimatorInterface) {
                val animatedValue = baseAnimator.animatedValue as Float
                animatorInterface.updateAnimationState { currentState ->
                    currentState.copy(archesExpansionProgress = animatedValue)
                }
            }
        }
        val bouncingRotation = object : AvatarViewAnimator {
            override val baseAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
                repeatCount = ValueAnimator.INFINITE
                duration = 3000L
                interpolator = BounceInterpolator()
            }

            override fun onValueUpdate(animatorInterface: AvatarView.AnimatorInterface) {
                val animatedValue = baseAnimator.animatedValue as Float
                animatorInterface.updateAnimationState { currentState ->
                    currentState.copy(rotationProgress = animatedValue)
                }
            }
        }*/
    }

    private fun updateAvatars(apply: AvatarView.() -> Unit) {
        binding.apply {
//            avatarView.apply()
//            avatarView2.apply()
        }
    }
}