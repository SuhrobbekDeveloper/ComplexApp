package com.example.client_example.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.client_example.R

class CircularProgressView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var progress = 0f
    private var progressColor1 = Color.BLUE
    private var backColor = Color.GRAY
    private var strokeWidth = 10f
    private var rectF = RectF()

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        progressColor1 =
            typedArray.getColor(R.styleable.CircularProgressView_progressColor, Color.BLUE)
        backColor = typedArray.getColor(R.styleable.CircularProgressView_backColor, Color.GRAY)
        strokeWidth = typedArray.getDimension(R.styleable.CircularProgressView_strokeWidth, 10f)
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var centerX = width / 2f
        var centerY = height / 2f
        var radius = (width - strokeWidth) / 2f


        //draw background Circle
        var bgPaint = Paint()
        bgPaint.color = backColor
        bgPaint.isAntiAlias = true
        bgPaint.style = Paint.Style.STROKE
        bgPaint.strokeWidth = strokeWidth
        canvas.drawCircle(centerX, centerY, radius, bgPaint)

        //draw progress arc
        val progressPaint = Paint()
        progressPaint.color = progressColor1
        progressPaint.isAntiAlias = true
        progressPaint.style = Paint.Style.STROKE
        progressPaint.strokeWidth = strokeWidth
        rectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(rectF, -90f, progress, false, progressPaint)
    }

    fun setProgress1(progress: Float) {
        this.progress = progress
        invalidate()
    }

    fun setProgressColor1(color: Int) {
        this.progressColor1 = color
        invalidate()
    }

    fun setBackgColor(color: Int) {
        this.backColor = color
        invalidate()
    }

    fun setStrokeWidth(width: Float) {
        this.strokeWidth = width
        invalidate()
    }
}