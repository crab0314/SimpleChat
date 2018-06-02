package com.yaya.simplechatapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/3.
 * 功能：
 */
public class CustomTitleBar extends LinearLayout {

    private Boolean isLeftBtnVisible;
    private int leftResId;

    private Boolean isLeftTvVisible;
    private String leftTvText;

    private Boolean isRightBtnVisible;
    private int rightResId;

    private Boolean isRightTvVisible;
    private String rightTvText;

    private Boolean isTitleVisible;
    private String titleText;

    private int backgroundResId;

    private ImageView leftBtn;
    private ImageView rightBtn;
    private TextView titleTv;
    private RelativeLayout barRlyt;
    private LinearLayout window;

    private int leftBtnHeight;
    private int leftBtnWidth;

    private int rightBtnHeight;
    private int rightBtnWidth;

    public CustomTitleBar(Context context) {
        this(context, null);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    /**
     * 初始化属性
     *
     * @param attrs
     */
    public void initView(AttributeSet attrs) {

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        /**-------------获取左边按钮属性------------*/
        isLeftBtnVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_left_btn_visible, false);
        leftResId = typedArray.getResourceId(R.styleable.CustomTitleBar_left_btn_src, -1);
        leftBtnWidth = typedArray.getInt(R.styleable.CustomTitleBar_left_btn_width, 22);
        leftBtnHeight = typedArray.getInt(R.styleable.CustomTitleBar_left_btn_height, 22);
        /**-------------获取左边文本属性------------*/
        isLeftTvVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_left_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_left_tv_text)) {
            leftTvText = typedArray.getString(R.styleable.CustomTitleBar_left_tv_text);
        }
        /**-------------获取右边按钮属性------------*/
        isRightBtnVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_right_btn_visible, false);
        rightResId = typedArray.getResourceId(R.styleable.CustomTitleBar_right_btn_src, -1);
        rightBtnWidth = typedArray.getInt(R.styleable.CustomTitleBar_right_btn_width, 22);
        rightBtnHeight = typedArray.getInt(R.styleable.CustomTitleBar_right_btn_height, 22);
        /**-------------获取右边文本属性------------*/
        isRightTvVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_right_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_right_tv_text)) {
            rightTvText = typedArray.getString(R.styleable.CustomTitleBar_right_tv_text);
        }
        /**-------------获取标题属性------------*/
        isTitleVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_title_visible, true);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_title_text)) {
            titleText = typedArray.getString(R.styleable.CustomTitleBar_title_text);
        }
        /**-------------背景颜色------------*/
        backgroundResId = typedArray.getResourceId(R.styleable.CustomTitleBar_barBackground, R.color.pure_white);

        typedArray.recycle();

        /**-------------设置内容------------*/
        View barLayoutView = View.inflate(getContext(), R.layout.common_title_bar, null);
        leftBtn = barLayoutView.findViewById(R.id.toolbar_left_btn);
        TextView leftTv = (TextView) barLayoutView.findViewById(R.id.toolbar_left_tv);
        titleTv = (TextView) barLayoutView.findViewById(R.id.toolbar_title_tv);
        rightBtn = barLayoutView.findViewById(R.id.toolbar_right_btn);
        TextView rightTv = (TextView) barLayoutView.findViewById(R.id.toolbar_right_tv);
        barRlyt = (RelativeLayout) barLayoutView.findViewById(R.id.toolbar_content_rlyt);

        window = barLayoutView.findViewById(R.id.window);

        if (isLeftBtnVisible) {
            leftBtn.setVisibility(VISIBLE);
        } else {
            leftBtn.setVisibility(GONE);
        }
        if (isLeftTvVisible) {
            leftTv.setVisibility(VISIBLE);
        } else {
            leftTv.setVisibility(GONE);
        }
        if (isRightBtnVisible) {
            rightBtn.setVisibility(VISIBLE);
        }
        if (isRightTvVisible) {
            rightTv.setVisibility(VISIBLE);
        } else {
            rightTv.setVisibility(GONE);
        }
        if (isTitleVisible) {
            titleTv.setVisibility(VISIBLE);
        } else {
            titleTv.setVisibility(GONE);
        }
        leftTv.setText(leftTvText);
        rightTv.setText(rightTvText);
        titleTv.setText(titleText);

        if (leftResId != -1) {
      //      leftBtn.setBackgroundResource(leftResId);
            leftBtn.setImageResource(leftResId);
            leftBtn.setPadding(25, 25, 25, 25);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) leftBtn.getLayoutParams();
//            params.height = DpUtils.dip2px(getContext(), leftBtnHeight);
//            params.width = DpUtils.dip2px(getContext(), leftBtnWidth);

            params.height = LayoutParams.MATCH_PARENT;
            params.width = LayoutParams.WRAP_CONTENT;

            leftBtn.setLayoutParams(params);

        }

        if (rightResId != -1) {
 //           rightBtn.setBackgroundResource(rightResId);

            rightBtn.setImageResource(rightResId);
            rightBtn.setPadding(25, 25, 25, 25);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rightBtn.getLayoutParams();
//            params.height = DpUtils.dip2px(getContext(), rightBtnHeight);
//            params.width = DpUtils.dip2px(getContext(), rightBtnWidth);
            params.height = LayoutParams.MATCH_PARENT;
            params.width = LayoutParams.WRAP_CONTENT;
            rightBtn.setLayoutParams(params);

        }
        if (backgroundResId != -1) {
            barRlyt.setBackgroundColor(getResources().getColor(R.color.main_color));
        }
        barLayoutView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        //将设置完成之后的View添加到此LinearLayout中
        addView(barLayoutView, 0);
    }

    public void setBackgroundResId(int resId) {
        backgroundResId = resId;
        barRlyt.setBackgroundColor(getResources().getColor(resId));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setWindowResId(int resId) {
        window.setBackground(getResources().getDrawable(resId));
    }

    public void setTitleText(String text) {
        if (titleTv != null) {
            titleTv.setText(text);
        }
    }


    public void setLeftClickListener(OnClickListener clickListener) {
        if (leftBtn != null) {
            leftBtn.setOnClickListener(clickListener);
        } else {
            Log.v("click", "左键暂未初始化");
        }
    }

    public void setRightClickListener(OnClickListener clickListener) {
        if (rightBtn != null) {
            rightBtn.setOnClickListener(clickListener);
        } else {
            Log.v("click", "右键暂未初始化");
        }
    }


}
