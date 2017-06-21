package com.lucky.baselib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lucky.baselib.R;
import com.lucky.baselib.base.widget.TitleBar;

import static android.view.View.inflate;

/**
 * Created by liuxuehao on 16/12/26.
 * Activity基础类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements TitleBar.OnTitleBarClickListener, IBaseView {

    protected LinearLayout mRootLayout;
    protected TitleBar mTitleBar;

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.baselib_activity_base);

        initViews();
        initToolbar();

        mPresenter = createPresenter();
        if (null != mPresenter) mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) mPresenter.detachView();
    }

    private void initViews() {
        mRootLayout = (LinearLayout) findViewById(R.id.baselib_root_layout);
        mTitleBar = (TitleBar) findViewById(R.id.titlebar_container);
    }

    protected void initToolbar() {
        if (null != mTitleBar.getToolBar()) {
            setSupportActionBar(mTitleBar.getToolBar());
        }

        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void setContentView(@LayoutRes int layoutId) {
        setContentView(inflate(this, layoutId, null));
    }

    public void setContentView(View view) {
        mRootLayout.addView(view, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (!isChild()) {
            onTitleChanged(getTitle(), getTitleColor());
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (TextUtils.isEmpty(mTitleBar.getTitle())) {
            mTitleBar.setOnlyTitleWithNoChange(title.toString());
        }
    }

    protected T createPresenter() {
        return null;
    }

    @Override
    public void onClickBack() {
        super.onBackPressed();
    }

    @Override
    public void onClickTitle() {

    }

    @Override
    public void onClickOptions() {

    }

    @Override
    public <T> void display(T data, int which) {

    }

    @Override
    public void error(String error, int which) {

    }
}
