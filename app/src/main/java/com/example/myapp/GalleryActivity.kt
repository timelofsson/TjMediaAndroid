package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class GalleryActivity: Fragment() {

    private var modified: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val v = inflater.inflate(R.layout.gallery_fragment, container, false)
//        val mWebView = v.findViewById<WebView>(R.id.mWebView)
//        mWebView.loadUrl("http://tjmedia.se/portfolio")
//
//        // Enable Javascript
//        val webSettings = mWebView.getSettings()
//        webSettings.setJavaScriptEnabled(true)
//        // Force links and redirects to open in the WebView instead of in a browser
//        mWebView.setWebViewClient(WebViewClient())
//
//        return v
        val v = inflater.inflate(R.layout.gallery_fragment, container, false)
        val webView = v.findViewById<WebView>(R.id.mWebView)

        /* JavaScript must be enabled if you want it to work, obviously */
        webView.settings.javaScriptEnabled = true

        /* WebViewClient must be set BEFORE calling loadUrl! */
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // hide element by class name
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('inner-intro')[0].style.display='none'; })()")

                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('header')[0].style.display='none'; })()")

                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('footer')[0].style.display='none'; })()")

                // hide element by id
//                webView.loadUrl("javascript:(function() { " +
//                        "document.getElementById('your_id').style.display='none';})()");

            }
        }

        /* load a web page */
        webView.loadUrl("http://82.209.132.70//portfolio")

        return v
    }
}