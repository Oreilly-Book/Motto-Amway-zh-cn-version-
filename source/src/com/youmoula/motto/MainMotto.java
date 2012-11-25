package com.youmoula.motto;

import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.DroidGap;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainMotto extends DroidGap {

    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        super.setBooleanProperty("keepRunning", false); 
        super.loadUrl("file:///android_asset/www/index.html",1000);
        
    }
    
    //--> webOS Style where exiting the app kills it. This simply restarts the app.
    protected void onResume() {
    	super.loadUrl("file:///android_asset/www/index.html", 1000);
        super.onResume();
     } 
    
    

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main_motto, menu);
//        return true;
//    }
    
}
