package com.example.zcj.myviewpractice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by zcj on 2016/11/22.
 */
public class CustomTitleView extends View {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本颜色
     */
    private int mTitleTextColor;
    /**
     * 文本大小
     */
    private int mTitleTextSize;
    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        super(context);
//        this(context,null);//重写构造方法
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 获得我们所定义的自定义样式属性
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义的样式属性
         * typeArrary 是类型数组，也是属性容器，用来存放各种属性的资源
         * 实例化 typeArray
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomTitleView,defStyleAttr,0);
        int n = a.getIndexCount();
        for (int i =0;i<n;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleColor:
                    //默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    //默认设置为16sp，typeValue也可以把sp转换为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
    }
}
