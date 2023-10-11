package com.example.eleventhwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class WBVActivity extends AppCompatActivity {
    private WebView webView;
    private Button bt_go,bt_back;
    private TextView user_tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_b_v);

        webView=findViewById(R.id.web);
        bt_go=findViewById(R.id.bt_go);
        bt_back=findViewById(R.id.bt_back);
        user_tx=findViewById(R.id.user_tx);

        webView.requestFocus();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com/SquareBlueH");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                if (url == null){
                    return false;
                } try {
                    if (url.startsWith("weixin://") || url.startsWith("alipays://")){
                        //类型目前用到的是微信、支付宝跳转方式，其他类型自拟
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                }catch (Exception e){
                    return false;
                }
                view.loadUrl(url);
                return true;
            }
        });
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://"+user_tx.getText().toString().trim());
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }
}