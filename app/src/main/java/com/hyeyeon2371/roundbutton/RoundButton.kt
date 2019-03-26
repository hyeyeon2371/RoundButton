package com.hyeyeon2371.roundbutton

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.support.v7.widget.AppCompatButton
import com.github.hyeyeon2371.R

class RoundButton : AppCompatButton {
    private lateinit var txt: String
    private var bgColor: Int? = 0
    private var txtColor: Int? = 0
    private var radius: Float? = 0f
    private var txtSize: Float? = 0f

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val typeArray = context?.obtainStyledAttributes(attrs, R.styleable.RoundButton)

        // string
        txt = typeArray?.getString(R.styleable.RoundButton_txt) ?: resources.getString(R.string.default_txt)

        // color
        txtColor =
            typeArray?.getColor(R.styleable.RoundButton_txtColor, resources.getColor(R.color.default_txtColor))
        bgColor = typeArray?.getColor(R.styleable.RoundButton_bgColor, resources.getColor(R.color.default_bgColor))

        // dimension
        txtSize = typeArray?.getDimension(
            R.styleable.RoundButton_txtSize,
            resources.getDimension(R.dimen.default_txtSize)
        )
        radius = typeArray?.getDimension(
            R.styleable.RoundButton_radius,
         resources.getDimension(R.dimen.default_radius)
        )

        typeArray?.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawBg(canvas)
        drawTxt(canvas)
    }

    private fun drawBg(canvas: Canvas?) {
        Paint().apply {
            color = bgColor!!
        }.let { paint ->
            RectF(0.0f, 0.0f, width.toFloat(), height.toFloat()).let {
                canvas?.drawRoundRect(it, radius!!.toFloat(), radius!!.toFloat(), paint)
            }
        }
    }

    private fun drawTxt(canvas: Canvas?) {
        Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = txtSize ?: resources.getDimension(R.dimen.default_txtSize)
            color = txtColor!!
        }.let {
            val xPos = (width / 2).toFloat()
            val yPos = (height / 2 - (it.descent() + it.ascent()) / 2)
            canvas?.drawText(txt, xPos, yPos, it)
        }
    }

    private fun convertDpToPixel(dp: Int): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

    private fun convertPixelToDp(pixel: Float): Int =
        (pixel / resources.displayMetrics.density).toInt()

    private fun convertColorToString(resId: Int): String =
        ("#" + Integer.toHexString(ContextCompat.getColor(context, resId)))

}