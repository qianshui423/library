package com.lucky.library.baselib;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lucky.baselib.base.BaseActivity;
import com.lucky.baselib.base.widget.TitleBar;
import com.lucky.library.R;

/**
 * Created by liuxuehao on 17/5/8.
 */

public class BaselibActivity extends BaseActivity {
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baselib_activity_base);

        initViews();
    }

    private void initViews() {
        mTitleBar = (TitleBar) findViewById(R.id.titlebar_container);

        mTitleBar.setDefaultBackAndOptions(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
    }
}
