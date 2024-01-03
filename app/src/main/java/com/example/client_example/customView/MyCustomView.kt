package com.example.client_example.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.client_example.R

class MyCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0).apply {
            try {
                paint.color = getColor(R.styleable.MyCustomView_customColor, Color.BLACK)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}