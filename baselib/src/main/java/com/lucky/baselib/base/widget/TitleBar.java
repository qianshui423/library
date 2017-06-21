package com.lucky.baselib.base.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.baselib.R;

/**
 * Created by liuxuehao on 17/5/8.
 */

public class TitleBar extends FrameLayout implements View.OnClickListener {

    private Context mContext;

    private Toolbar mToolbar;
    private ImageView mIvBack;
    private TextView mTvTitle;
    private ImageView mIvOptions;

    private int mResBack;
    private int mResOptions;

    private OnTitleBarClickListener mOnTitleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        mOnTitleBarClickListener = onTitleBarClickListener;
    }

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.baselib_toolbar_common, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mToolbar = (Toolbar) findViewById(R.id.base_toolbar);

        mIvBack = (ImageView) findViewById(R.id.base_toolbar_back);
        mTvTitle = (TextView) findViewById(R.id.base_toolbar_title);
        mIvOptions = (ImageView) findViewById(R.id.base_toolbar_options);
    }

    @Override
    public void onClick(View v) {
        if (null == mOnTitleBarClickListener) return;
        int id = v.getId();
        if (id == R.id.base_toolbar_back) {
            mOnTitleBarClickListener.onClickBack();
        } else if (id == R.id.base_toolbar_title) {
            mOnTitleBarClickListener.onClickTitle();
        } else if (id == R.id.base_toolbar_options) {
            mOnTitleBarClickListener.onClickOptions();
        }
    }

    public void setOnlyTitle(String title) {
        mIvBack.setVisibility(GONE);
        mTvTitle.setVisibility(VISIBLE);
        mIvOptions.setVisibility(GONE);

        setTitle(title);
    }

    public void setOnlyTitleWithNoChange(String title) {
        setTitle(title);
    }

    public void setTitleWithDefault(String title) {
        mIvBack.setVisibility(VISIBLE);
        mTvTitle.setVisibility(VISIBLE);
        mIvOptions.setVisibility(VISIBLE);

        setTitle(title);
    }

    public void setTitleWithDefaultOptions(String title) {
        mIvBack.setVisibility(GONE);
        mTvTitle.setVisibility(VISIBLE);
        mIvOptions.setVisibility(VISIBLE);

        setTitle(title);
    }

    public void setTitleWithDefaultBack(String title) {
        mIvBack.setVisibility(VISIBLE);
        mTvTitle.setVisibility(VISIBLE);
        mIvOptions.setVisibility(GONE);

        setTitle(title);
    }

    public void setDefaultBackAndOptions(@DrawableRes int resBack, @DrawableRes int resOptions) {
        mIvBack.setVisibility(VISIBLE);
        mIvOptions.setVisibility(VISIBLE);

        mResBack = resBack;
        mResOptions = resOptions;

        setBack(mResBack);
        setOptions(mResOptions);
    }

    public String getTitle() {
        return mTvTitle.getText().toString();
    }

    public Toolbar getToolBar() {
        return mToolbar;
    }

    protected View customTitleBar(@LayoutRes int layoutRes) {
        for (int i = mToolbar.getChildCount() - 1; i > 0; i--) {
            mToolbar.removeViewAt(i);
        }

        View customView = LayoutInflater.from(mContext).inflate(layoutRes, null);
        mToolbar.addView(customView, new RelativeLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        ));
        return customView;
    }

    private void setTitle(String title) {
        mTvTitle.setText(title);
    }

    private void setBack(@DrawableRes int res) {
        mIvBack.setImageResource(res);
    }

    private void setOptions(@DrawableRes int res) {
        mIvBack.setImageResource(res);
    }

    public interface OnTitleBarClickListener {
        void onClickBack();

        void onClickTitle();

        void onClickOptions();
    }
}
