package uz.sandi.estudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    final String username = "bak_ax104";
    final String password = "bak_ax104IM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        final SwipeRefreshLayout homeRefresh = findViewById(R.id.home_refresh);


        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://estudy.iiau.uz/login/index.php");



        webView.setWebViewClient(webViewClient);

        homeRefresh.setOnRefreshListener(() -> {
            webView.reload();
            homeRefresh.setRefreshing(false);
        });
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
            webView.setWebViewClient(webViewClient);
        } else {
            super.onBackPressed();
        }
    }

    WebViewClient webViewClient = new WebViewClient(){
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl("javascript:window.onload=(function(){document.getElementById('username').value = '"+username+"'; document.getElementById('password').value = '"+password+"';})();");
            view.loadUrl("javascript:(function() {var z = document.getElementById('loginbtn').click(); })()");
            view.loadUrl("javascript:(function() {var z = document.getElementById('rememberusername').checked = true; })()");
            view.loadUrl("javascript:(function() {var z = document.getElementById('single_button5f971a185783425').click(); })()");
            view.loadUrl("javascript:(function() {var z = document.getElementsByClassName('btn btn-secondary')[0].click(); })()");
        }
    };
}