package com.example.client_example.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.client_example.R
import com.example.client_example.R.styleable.MyCustomView2

// not understandable in documentation

class MyCustomView2 : View {
    private val paint = Paint()
    private var rect = Rect(0, 0, 50, 50)
    private var squareColor: Int = 0
    private var squareSize: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defstyleAttr: Int) : super(
        context,
        attrs,
        defstyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas.drawRect(rect, paint)
    }

    private fun init(attributeSet: AttributeSet?) {
        attributeSet?.let {
            val typedArray = context.obtainStyledAttributes(attributeSet, MyCustomView2)
            squareColor = typedArray.getColor(R.styleable.MyCustomView2_square_color, Color.RED)
            squareSize = typedArray.getDimensionPixelSize(R.styleable.MyCustomView2_size, 50)
            typedArray.recycle()
        }
    }
}