package com.example.client_example

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import com.example.client_example.databinding.FragmentDemoSheetBinding

class MySheetFragment : SuperBottomSheetFragment() {
    private lateinit var binding: FragmentDemoSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentDemoSheetBinding.inflate(inflater)

        return binding.root
    }

    override fun getPeekHeight(): Int = 1200
    override fun getBackgroundColor(): Int = resources.getColor(R.color.yellow100)
    override fun getCornerRadius(): Float = 80f
    override fun isSheetAlwaysExpanded(): Boolean = false
    override fun isSheetCancelableOnTouchOutside(): Boolean = true
    override fun isSheetCancelable(): Boolean = true
    override fun animateCornerRadius(): Boolean = true
    override fun animateStatusBar(): Boolean = true
    override fun getExpandedHeight(): Int {
        return -2
    }

}