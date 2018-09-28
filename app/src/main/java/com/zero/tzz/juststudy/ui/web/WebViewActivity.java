package com.zero.tzz.juststudy.ui.web;

import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseActivity;

import butterknife.BindView;


public class WebViewActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.progressbar)
    ProgressBar mProgressbar;
    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initEventAndData() {

    }
}
