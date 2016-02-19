package com.numerex.localweb;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends ActionBarActivity {

    private class LocalWebClient extends WebViewClient {
        public Context context = null;
        public LocalWebClient(Context context) {
            this.context = context;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("d", "finished");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new LocalWebClient(this));

        // does not call onPageFinished with webview v 48
        webView.loadDataWithBaseURL("/", "<body style='background-color: blue;'></body>", "text/html", "UTF-8", "");

        // calls onPageFinished as expected
        // webView.loadUrl("https://google.com");
    }
}
