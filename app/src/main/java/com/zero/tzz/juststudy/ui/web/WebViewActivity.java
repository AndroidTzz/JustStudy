package com.zero.tzz.juststudy.ui.web;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseActivity;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview_client)
    WebView webview_client;
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    private String mUrl;
    private String mTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initEventAndData() {

        mUrl = getIntent().getStringExtra("url");
        mTitle = getIntent().getStringExtra("title");

        toolbar.setTitle(mTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webview_client.setInitialScale(1);
        webview_client.getSettings().setJavaScriptEnabled(true);
        webview_client.getSettings().setLoadWithOverviewMode(true);
        webview_client.getSettings().setUseWideViewPort(true);
        webview_client.setWebChromeClient(getDefaultChromeWebClient());
        webview_client.setWebViewClient(getDefaultWebClient());
        webview_client.loadUrl(mUrl);

//        progress_bar.progressDrawable = if (intent?.extras != null && intent.extras.containsKey(BUNGLE_PROGRESS_DRAWABLE))
//        ContextCompat.getDrawable(this, intent.extras.getInt(BUNGLE_PROGRESS_DRAWABLE))
//        else ContextCompat.getDrawable(this, R.drawable.custom_progress)
    }

    @Override
    public void onBackPressed() {
        if (webview_client.canGoBack()) {
            webview_client.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public WebChromeClient getDefaultChromeWebClient() {
        return new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progress_bar.setProgress(newProgress);
            }
        };
    }

    public WebViewClient getDefaultWebClient() {
        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (progress_bar.getVisibility() == View.GONE) {
                    progress_bar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progress_bar.getVisibility() == View.VISIBLE) {
                    progress_bar.setVisibility(View.GONE);
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.action_share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, webview_client.getUrl());
            startActivity(Intent.createChooser(shareIntent, getString(R.string.action_share)));
        } else if (item.getItemId() == R.id.action_refresh) {
            webview_client.reload();
        }
        return super.onOptionsItemSelected(item);
    }
}